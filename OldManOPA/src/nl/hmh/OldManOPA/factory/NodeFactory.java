/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.hmh.OldManOPA.factory;

import java.io.File;
import java.io.FilenameFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import nl.hmh.OldManOPA.ClassFilenameFilter;

import nl.hmh.OldManOPA.model.Node;
import nl.hmh.OldManOPA.model.INode;
import nl.hmh.OldManOPA.model.Strategy;
import nl.hmh.OldManOPA.model.decorator.INodeConcreteDecorator;

/**
 *
 * @author Pehr
 */
public class NodeFactory {

	private static final String path = "nl.hmh.OldManOPA.strategy";

	/*** Start of Singleton implementation ***/

	private static NodeFactory instance = null;

	private static NodeFactory getInstance() {
		if (instance == null) {
			instance = new NodeFactory();
			instance.initialize();
		}

		return instance;
	}

	/*** End of Singleton implementation ***/

	private Hashtable<String, Strategy> strategies;

	private NodeFactory() {
		strategies = new Hashtable<String, Strategy>();
	}

	private void initialize() {
		//String dir = getClassLocation();
		String dir = "C:/Users/Steven/Documents/GitHub/HowToPayHereFor/OldManOPA/build/classes/nl/hmh/OldManOPA/strategy";

		try {
            File           cFile   = new File(dir);
            FilenameFilter cFilter = new ClassFilenameFilter();
            String[]       cList   = cFile.list( cFilter );
            int            nSize;
            String         sName;

            for ( int n=0; n<cList.length; n++ )
            {
            	nSize = cList[n].indexOf('$');

            	if (nSize == -1) {
	                nSize = cList[n].indexOf('.');
    	            sName = cList[n].substring(0, nSize);

        	        Class.forName(path + "." + sName);
            	}
            }
        }
        catch(Exception exception) {
            System.out.println("error in loading files");
        }
	}

	public static void assign(String ID, Strategy strategy) {
		getInstance().strategies.put(ID, strategy);
	}

	public static INode produceNode(String ID) {
		Strategy strategy = (Strategy) getInstance().strategies.get(ID);

		Node node = new Node(strategy);
		return new INodeConcreteDecorator(node);
	}

    private String getClassLocation() {
        final Class  cls           = getClass();
        URL          result        = null;
        final String clsAsResource = cls.getName().replace('.','/').concat(".class");

        final ProtectionDomain pd = cls.getProtectionDomain();
        // java.lang.Class contract does not specify if 'pd' can ever be null;
        // it is not the case for Sun's implementations, but guard against null
        // just in case:
        if (pd != null) {
            final CodeSource cs = pd.getCodeSource();
            // 'cs' can be null depending on the classloader behavior:
            if (cs != null)
                result = cs.getLocation();

            if (result != null) {
                // Convert a code source location into a full class file location
                // for some common cases:
                if (result.getProtocol().equals("file")) {
                    try {
                        if (result.toExternalForm().endsWith(".jar") || result.toExternalForm().endsWith(".zip")) {
                            result = new URL("jar:".concat(result.toExternalForm()).concat("!/").concat (clsAsResource));
                        }
						else {
                            if (new File(result.getFile()).isDirectory())
                                result = new URL (result, clsAsResource);
                        }
                    }
                    catch (MalformedURLException ignore) {}
                }
            }
        }

        if (result == null) {
            // Try to find 'cls' definition as a resource; this is not
            // documented to be legal, but Sun's implementations seem to allow this:
            final ClassLoader clsLoader = cls.getClassLoader();
            result = clsLoader != null ? clsLoader.getResource (clsAsResource) : ClassLoader.getSystemResource(clsAsResource);
        }

        String  value = "";

        if (result != null) {
            value   = path.replace( '.', '/' ) + '/';
            value   = result.toString() + value;
            value   = replace( value, "%20", " " );
            value   = replace( value, "file:/", "" );
        }

        return value;
    }

    private String replace(String sText, String sOldText, String sNewText) {
        int     position    = 0,
                newPosition,
                step        = sOldText.length();
        String  sResult     = "";

        while ((newPosition = sText.indexOf(sOldText,position)) >= 0) {
            sResult    += sText.substring( position, newPosition );
            sResult    += sNewText;
            position    = newPosition + step;
        }

        sResult += sText.substring(position);
        return sResult;
    }
}
