package com.example.helloandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Find TextView in the layout
        TextView displayName = findViewById(R.id.displayName);

        // Receive data from MainActivity
        Intent intent = getIntent();
        String name = intent.getStringExtra("userName");

        // Display the name or a fallback message
        if (name != null && !name.trim().isEmpty()) {
            displayName.setText("Hello, " + name + "!");
        } else {
            displayName.setText("No name received.");
        }
    }
}
