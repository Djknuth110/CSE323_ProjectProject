package stonybrook.projectproject.cse323;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;

public class SocketClient extends AsyncTask<Void, Void, String> {

    private String ip;
    private int port;
    String responce = "";
    TextView textResponce;

    public SocketClient(String ip) {
        this.ip = ip;
    }

    public  SocketClient(String ip, int port) {
        this.port = port;
    }

    /* timeDelay is used to prevent user
    from rapidly entering too many commands before
    the they can be processed. CURRENTLY NOT BEING USED
     */
    private static int timeDelay = 3;


    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;

    }

    @Override
    protected String doInBackground(Void... voids) {
        Socket socket = null;
        boolean connected = false;
        boolean exit = false;

        try {
            socket = new Socket(getIp(), getPort()); //Creates and initializes a new socket
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead = 0;
            InputStream inputStream = socket.getInputStream();

            do {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                responce += byteArrayOutputStream.toString("UTF-8");


            } while ((bytesRead = inputStream.read(buffer)) != -1);

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return responce;

    }

    @Override
    protected  void onPostExecute(String result) {
        textResponce.setText(responce);
        super.onPostExecute(result);
    }
}


