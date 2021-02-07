package co.ingrow.android.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import co.ingrow.android.action.InGrowClient;
import co.ingrow.android.action.InGrowSession;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sendEventsButton).setOnClickListener(v -> {
            // HashMap could have any basic types of Values like "String", "Int", "boolean", "Float", "Double" but arrays or any other nested values are not supported
            HashMap events = new HashMap<>();
            try {
                events.put("name", "Nader");
                events.put("position", "Developer");
                events.put("isActive", true);
                events.put("numberOfCommits", 12);

                InGrowClient.client().logEvents(events);
            } catch (Exception e){
                Log.d("ERROR: ", "SEND EVENTS FAILED");
            }

        });

        findViewById(R.id.loginButton).setOnClickListener(v -> {

            // You could get benefits of Enrichment by adding it with an anonymous_id while you are initialize the InGrowClient
            // So you can add user_id any time you might have it in entire project and keep the stream of user data connected with actions before login or register
            InGrowClient.enrichmentBySession(new InGrowSession("user_id"));
            Toast.makeText(this, getString(R.string.login_successful), Toast.LENGTH_SHORT).show();

        });

        findViewById(R.id.sendEventsWithEnrichmentButton).setOnClickListener(v -> {
            HashMap events = new HashMap<>();
            try {
                events.put("name", "Nader");
                events.put("position", "Developer");
                events.put("isActive", true);
                events.put("numberOfCommits", 12);
                events.put("isMarried", true);
                events.put("weight", 70.5);

                InGrowClient.client().logEvents(events);
            } catch (Exception e){
                Log.d("ERROR: ", "SEND EVENTS WITH ENRICHMENT FAILED");
            }
        });
    }

}