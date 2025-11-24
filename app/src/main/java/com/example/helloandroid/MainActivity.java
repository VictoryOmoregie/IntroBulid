package com.example.helloandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_NAME = "username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. DECLARE ALL UI COMPONENTS
        TextView welcomeText = findViewById(R.id.welcomeText);
        EditText nameInput = findViewById(R.id.nameInput);
        Button saveButton = findViewById(R.id.saveButton);
        Button clearButton = findViewById(R.id.clearButton);
        Button nextButton = findViewById(R.id.nextButton); // For navigation

        // SharedPreferences setup
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedName = prefs.getString(KEY_NAME, null);

        // Load stored name if available
        if (savedName != null) {
            welcomeText.setText("Welcome back, " + savedName + "!");
        } else {
            welcomeText.setText(R.string.msg_welcome); // Set initial welcome text from strings.xml
        }

        // 2. SETUP THE SAVE BUTTON LISTENER
        saveButton.setOnClickListener(saveView -> {
            String name = nameInput.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save name to SharedPreferences
            prefs.edit().putString(KEY_NAME, name).apply();
            welcomeText.setText("Hello, " + name + "!");
            Toast.makeText(this, "Name saved!", Toast.LENGTH_SHORT).show();
        });

        // 3. SETUP THE CLEAR BUTTON LISTENER
        clearButton.setOnClickListener(clearView -> {
            // Remove name from SharedPreferences
            prefs.edit().remove(KEY_NAME).apply();
            welcomeText.setText(R.string.msg_welcome); // Reset to default welcome message
            nameInput.setText(""); // Clear the input field
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();
        });

        // 4. SETUP THE NAVIGATION BUTTON LISTENER
        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            // Pass the current user's name to the next screen
            String currentName = prefs.getString(KEY_NAME, "Guest");
            intent.putExtra("USERNAME_KEY", currentName);

            startActivity(intent);
        });
    }
}