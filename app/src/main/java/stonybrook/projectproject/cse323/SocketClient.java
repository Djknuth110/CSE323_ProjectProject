package stonybrook.projectproject.cse323;


import android.os.AsyncTask;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient extends AsyncTask<String, Void, Void> {

    private String ip;
    private int port;
    //private boolean running = false;
    //TextView textResponse;
    private Socket socket;
    //DataOutputStream dos;
    private PrintWriter pw;


    public SocketClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected Void doInBackground(String... voids) {

        String message = voids[0];

        try {
            socket = new Socket(ip,port);
            pw = new PrintWriter(socket.getOutputStream());

            pw.write(message);
            pw.flush();
            pw.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkConnection(Socket socket) {
        boolean connected =false;
        try {
            socket.getInetAddress().isReachable(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connected;
    }

}


