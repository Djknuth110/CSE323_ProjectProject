package stonybrook.projectproject.cse323;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SocketClientUI extends AppCompatActivity {
    private static int TIME_OUT = 5000;
    private String ip;
    private int port;
    private boolean running;


    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_client_ui);

        /*Retrieves the IP and Port from the ConnectionScreen class
         */
        setIpAndPort();

        /*Sends IP and Port to SocketClient to attempt to connect to
        server
         */

        startSocketClient(ip,port);
        /* Creates an new instance of SocketClient class, loads
        loading screen, then opens MainActivity after 4000ms
        (needs to be changed to exit if connection is established or not
         */
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                startSocketClient(ip,port);
                System.out.print("I AM A TEST STRING");
                finish();
            }
        },TIME_OUT);

        if (!running){
            System.out.println("Connection Failed");

        }

    }

    /*Retrieves port number and IP address from ConnectionScreen
      class.
      */
    public void setIpAndPort() {
        Bundle bundle = getIntent().getExtras();
        ip = bundle.getString("ip");
        port = bundle.getInt("port");
    }

    /* Creates the Main Activity when the 'connect' button
    is pressed and sends the users ip and port number to it.
    */
    public void startSocketClient(String ip, int port) {
        SocketClient socketClient = new SocketClient(ip,port);
        socketClient.doInBackground();
        setRunning(socketClient.checkConnection());

    }

    /*Starts the main activity
     */
    public void startMain(){
        Intent intent = new Intent(SocketClientUI.this,MainActivity.class);
        startActivity(intent);
    }
}
