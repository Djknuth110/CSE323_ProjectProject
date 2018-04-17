package stonybrook.projectproject.cse323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    private int selectedButton;

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
        ConnectionScreen connectionScreen = new ConnectionScreen(); //Retrieves Login Credentials
        //SocketClient socketClient = new SocketClient(connectionScreen.getIp(),connectionScreen.getPort()); //Creates Client Side Socket



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
        Button btn4 = (Button) (findViewById(R.id.btn4));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBtnValue(4);
            }
        });


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
