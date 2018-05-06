package stonybrook.projectproject.cse323;

import android.content.Intent;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private String ip;
    private int port;
    private  SocketClient socketClient = null;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets ip and port variables
        setIpAndPort();

        //Sets socket upon creation but is redundant due to refresh socket method
        setSocketClient(ip,port);

        ImageButton btn1 = (ImageButton) (findViewById(R.id.imageButton1));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("1");

            }
        });
        ImageButton btn2 = (ImageButton) (findViewById(R.id.imageButton2));
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("2");
            }
        });
        ImageButton btn3 = (ImageButton) (findViewById(R.id.imageButton3));
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                 socketClient.execute("3");
            }
        });
        ImageButton btn4 = (ImageButton) (findViewById(R.id.imageButton4));
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("4");
            }
        });
        ImageButton btn5 = (ImageButton) (findViewById(R.id.imageButton5));
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("5");
            }
        });
        ImageButton btn6 = (ImageButton) (findViewById(R.id.imageButton6));
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("6");
            }
        });
        ImageButton btn7 = (ImageButton) (findViewById(R.id.imageButton7));
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("7");
            }
        });
        ImageButton btn8 = (ImageButton) (findViewById(R.id.imageButton8));
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("8");
            }
        });
        ImageButton btn9 = (ImageButton) (findViewById(R.id.imageButton9));
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("9");
            }
        });
        ImageButton btn10 = (ImageButton) (findViewById(R.id.imageButton10));
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("10");
            }
        });
        ImageButton btn11 = (ImageButton) (findViewById(R.id.imageButton11));
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("11");
            }
        });
        ImageButton btn12 = (ImageButton) (findViewById(R.id.imageButton12));
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("12");
            }
        });

        ImageButton homeBtn = (ImageButton) (findViewById(R.id.homeButton));
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("home");//Sends message that tells PC program to go back to home page
            }
        });

        ImageButton backBtn = (ImageButton) (findViewById(R.id.backButton));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshSocket();
                socketClient.execute("back");
            }
        });

    }

    /*Retrieves port number and IP address from ConnectionScreen
    class.
     */
    public void setIpAndPort() {
        Bundle bundle = getIntent().getExtras();
        ip = bundle.getString("ip");
        port = bundle.getInt("port");
    }

    public  void setSocketClient(String ip,int port) {
        socketClient = new SocketClient(ip,port);
    }

    /*After each button is pressed the socket is recreated
     *AsyncTask must be recreated after calling  execute
     */
    public void refreshSocket() {
        socketClient = new SocketClient(ip,port);
    }


}
