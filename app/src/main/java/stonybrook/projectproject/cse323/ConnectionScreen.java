package stonybrook.projectproject.cse323;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConnectionScreen extends AppCompatActivity {

    private EditText portRetriever, ipRetriever;  //Used to hold user connection input.
    private String ipAddress = "";
    private int portNum = 0;
    private Button connect;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_screen);

        ipRetriever = (EditText) findViewById(R.id.ipAddress);
        portRetriever = (EditText) findViewById(R.id.portNum);
        connect = (Button) findViewById(R.id.connect);

        /*Sets what you want the button to do once the user selects
        the connect button.
         */
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipAddress = ipRetriever.getText().toString();
                portNum = Integer.valueOf(portRetriever.getText().toString()); //Retrieves and converts portNum to an int
                startMain(ipAddress,portNum); //Calls startMain method

            }
        });

    }
        /* Creates the Main Activity when the 'connect' button
        is pressed and sends the users ip and port number to it.
         */
        public void startMain(String ip, int port) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("ip", ip); //This sends the ip and port variables to the MainActivity Class
            intent.putExtra("port", port);
            startActivity(intent);

        }

}
