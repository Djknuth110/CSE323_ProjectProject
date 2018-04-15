package stonybrook.projectproject.cse323;

import android.os.AsyncTask;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class SocketClient extends AsyncTask<int, Void, Void> {

    Socket displayPC;
    private String ip;
    private int port;

    /* timeDelay is used to prevent user
    from rapidly entering too many commands before
    the they can be processed.
     */
    private static int timeDelay = 3;

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;

    }
        protected void tryConnection() {
            try {
                displayPC = new Socket(getIp(),  getPort());
                printWriter.write(message)


            }catch (IOException e) {
                e.printStackTrace();
            }

        }
}
