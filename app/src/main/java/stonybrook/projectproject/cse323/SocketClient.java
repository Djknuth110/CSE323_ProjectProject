package stonybrook.projectproject.cse323;


import android.os.AsyncTask;
import android.os.NetworkOnMainThreadException;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;

public class SocketClient extends AsyncTask<Void, Void, String> {

    private String ip;
    private int port;
    private boolean running = false;
    String responce = "";
    TextView textResponce;


    /* timeDelay is used to prevent user
     from rapidly entering too many commands before
     the they can be processed. CURRENTLY NOT BEING USED
      */
    private static int timeDelay = 3;

    public  SocketClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    protected String doInBackground(Void... voids) {
        Socket socket = null;

        System.out.println("Attemting to connect..");
        try {
            socket = new Socket(ip,port); //Creates and initializes a new socket
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
            byte[] buffer = new byte[1024];

            int bytesRead = 0;
            InputStream inputStream = socket.getInputStream();

            do {

                System.out.println("Connection Successful");
                running = true;
                byteArrayOutputStream.write(buffer, 0, bytesRead);
                responce += byteArrayOutputStream.toString("UTF-8");


            } while ((bytesRead = inputStream.read(buffer)) != -1);

        }
        catch (IOException e) {
            e.printStackTrace();
        }catch (NetworkOnMainThreadException e) {
            System.out.print("Failed: Network On Main Thread Exception.");
        }
        finally {
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

    public boolean checkConnection() {
        return running;
    }

    @Override
    protected  void onPostExecute(String result) {
        textResponce.setText(responce);
        super.onPostExecute(result);
    }
}


