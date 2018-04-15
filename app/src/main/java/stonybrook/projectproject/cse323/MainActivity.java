package stonybrook.projectproject.cse323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) (findViewById(R.id.btn1));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(1);
            }
        });
        Button btn2 = (Button) (findViewById(R.id.btn2));
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(2);
            }
        });

        Button btn3 = (Button) (findViewById(R.id.btn3));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(3);
            }
        });
    }

    /* Sends value of button pressed

     */
    public void sendBtnValue(int value) {

    }
    /* Attempts to create connection with
    PC side server
     */
    public void establishConnection(String ip, int port) {
        SocketClient openConnection = new SocketClient();
        openConnection.setIp(ip);
        openConnection.setPort(port);
    }
}
