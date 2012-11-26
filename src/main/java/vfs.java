import org.crsh.vfs.jboss.ConfigurableStreamHandlerFactory;
import org.crsh.vfs.jboss.Handler;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created with IntelliJ IDEA.
 * User: drieu
 * Date: 24/11/12
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class vfs {


    public static void main(String[] args) {
        URL url = null;
        try {
            URL.setURLStreamHandlerFactory(new ConfigurableStreamHandlerFactory("vfs", new Handler()));

            System.out.println("============================================>BEGIN TEST");
            URL[] urls = new URL[2];
            urls[0] = new URL("file:/home/drieu/workspaces/intellij/vfs/src/main/resources/vfs/");
            urls[1] = new URL("vfs:/home/drieu/workspaces/intellij/vfs/src/main/resources/vfs/");

            // Create the classloader
            URLClassLoader urlClassloader = new URLClassLoader(urls);

            Class<?> clazz = urlClassloader.getClass();
            for(URL mUrl : urlClassloader.getURLs()) {
                System.out.println("Contains :" +mUrl.getPath() + "  with protocol " + mUrl.getProtocol());
            }

            // Protocole file
            URL myFileUrl = urlClassloader.getResource("tmp1.txt");
            if (null != myFileUrl) {
                System.out.println("My protocol :" + myFileUrl.getProtocol());
            } else {
                System.out.printf("ECHEC !");
            }

            // Protocole vfs
            URL myUrl = urlClassloader.getResource("vfs:/tmp1.txt");
            if (null != myUrl) {
                System.out.println("My protocol :" + myUrl.getProtocol());
            } else {
                System.out.printf("ECHEC !");
            }


            System.out.println("============================================>END TEST");
        } catch (MalformedURLException mexc) {
            System.out.println(mexc.getMessage());
        }
    }
}
