package com.example.helloandroid;

<<<<<<< HEAD
import android.os.Bundle;
import android.widget.Button;
=======
import android.content.Intent;
import android.os.Bundle;
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
<<<<<<< HEAD
=======

>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

<<<<<<< HEAD
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
=======
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
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
