package bhakadekailas.broadcastreceiverexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    MyReceiver myReceiver;
    IntentFilter intentFilter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonForManifest = findViewById(R.id.buttonForManifest);
        Button buttonFromJavaFile = findViewById(R.id.buttonFromJavaFile);
        context = MainActivity.this;
        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter("I am from Java Class File");

        buttonForManifest.setOnClickListener(v -> {
            Intent intent = new Intent("I am from Manifest File");
            sendBroadcast(intent);
        });

        buttonFromJavaFile.setOnClickListener(v -> {
            Intent intent = new Intent("I am from Java Class File");
            sendBroadcast(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
        registerReceiver(myReceiver, intentFilter);
        registerReceiver(new AirlineModeChangedReceiver(), new IntentFilter("android.intent.action.AIRPLANE_MODE"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
        unregisterReceiver(myReceiver);
        unregisterReceiver(new AirlineModeChangedReceiver());
    }
}