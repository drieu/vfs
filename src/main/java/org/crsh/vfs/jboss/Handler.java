package org.crsh.vfs.jboss;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created with IntelliJ IDEA.
 * User: drieu
 * Date: 18/11/12
 * Time: 20:48
 * To change this template use File | Settings | File Templates.
 */
public class Handler extends URLStreamHandler {

    @Override
    protected URLConnection openConnection(URL url) throws IOException {

        //TODO
        URL newURL = new URL("file:/home/drieu/workspaces/intellij/vfs/src/main/resources/vfs/");
        return newURL.openConnection();

    }
}
