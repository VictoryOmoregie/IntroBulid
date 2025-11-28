package com.example.helloandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView displayName = findViewById(R.id.displayName);
        Button backButton = findViewById(R.id.backButton);

        // Receive data from the Intent
        String name = getIntent().getStringExtra("username");
        if (name != null) {
            displayName.setText("Hello again, " + name + "!");
        }

        backButton.setOnClickListener(v -> finish()); // closes current Activity
    }
}