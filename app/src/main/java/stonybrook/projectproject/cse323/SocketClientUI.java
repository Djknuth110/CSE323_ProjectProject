package stonybrook.projectproject.cse323;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.Socket;

public class SocketClientUI extends AppCompatActivity {

    //This value changes how long the loading screen loads
    private static int TIME_OUT = 5000;

    private String ip;
    private int port;
    private boolean connected = true; //Setting this as true but a ServerSocket needs to be created on the Application to be able to talk with the server for things such as connection status, and which buttons are available to press in each menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_client_ui);

        //Retrieves the IP and Port from the ConnectionScreen class
        setIpAndPort();

        /* Creates an new instance of SocketClient class, loads
        loading screen, then opens MainActivity after 4000ms
        (needs to be changed to exit if connection is established or not
         */
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                //checkSocketClient(ip,port);

                SocketClient socketClient = new SocketClient(ip,port);
                socketClient.execute("Are You Alive?");

                if (!connected) {
                    System.out.println("Connection Failed");

                }else{
                    startMain();

                    //finish() can be called to kill (destroy) an Activity instance. If you don't need to close your Activity manual, which is true in many cases, you don't need to call this method.
                    //But if you require a button somewhere in your activity that says "close", then you should use this method. But in general the back button behavior in Android will handle things like this.
                    //The back button does not actually finish your activity, finish() calls the onDestory() method right away, while the back button does not.
                    //When the back button is pressed, the onStop() method is called, but the onDestory() method call might be delayed by the system, this so that the Activity can be resumed by the system which is cheaper (in resources) than a full restart.
                    finish(); //This may not be needed here.
                }
                finish();
            }
        },TIME_OUT);
    }


    /*Retrieves port number and IP address from ConnectionScreen
      class.
      */
    public void setIpAndPort() {
        Bundle bundle = getIntent().getExtras();
        ip = bundle.getString("ip");
        port = bundle.getInt("port");
    }


    /* Sends IP and port to main activity then starts it  */
    public void startMain(){
        Intent intent = new Intent(SocketClientUI.this,MainActivity.class);
        intent.putExtra("ip", ip); //This sends the ip and port variables to SocketClientUI Class
        intent.putExtra("port", port);
        startActivity(intent);
    }
}
