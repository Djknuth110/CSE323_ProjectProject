package stonybrook.projectproject.cse323;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConnectionScreen extends AppCompatActivity {

    private EditText portRetriever;
    private EditText ipRetriever;
    private String ipAddress;
    private int portNum; //This needs to be an int
    private Button connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_screen);

        ipRetriever = findViewById(R.id.ipAddress);
        portRetriever = findViewById(R.id.portNum);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipAddress = ipRetriever.getText().toString().trim();
            }
        });
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String portNumHolder;
                portNumHolder = portRetriever.getText().toString().trim(); //Need to retrieve this as an int
                portNum = Integer.parseInt(portNumHolder); //Converts User input for port number to an int
            }
        });

    }

    public String getIp() {
        return ipAddress;
    }

    public  int getPort() {
        return portNum;
    }

}
