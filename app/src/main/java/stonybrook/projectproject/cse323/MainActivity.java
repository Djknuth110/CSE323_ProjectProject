package stonybrook.projectproject.cse323;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    private String ipAddress;
    private int portNum;
    private int selectedButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setIpAndPort();
        //startSocketClient();


        Button btn1 = (Button) (findViewById(R.id.imageButton1));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(1);
                System.out.println(ipAddress + " " + portNum);
            }
        });
        Button btn2 = (Button) (findViewById(R.id.imageButton2));
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(2);
            }
        });
        Button btn3 = (Button) (findViewById(R.id.imageButton3));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(3);
            }
        });

    }

    public void startSocketClient() {
        SocketClient socketClient = new SocketClient(ipAddress,portNum);
        System.out.print(ipAddress+ " " + portNum);

    }

    /*Retrieves port number and IP address from ConnectionScreen
    class.
     */
    public void setIpAndPort() {
        Bundle bundle = getIntent().getExtras();
        ipAddress = bundle.getString("ip");
        portNum = bundle.getInt("port");
    }

    public int getSelectedButton(){
        return selectedButton;
    }

    /* Sends value of button pressed
     */
    public void sendBtnValue(int selectedButton) {
        this.selectedButton = selectedButton;
    }


}
