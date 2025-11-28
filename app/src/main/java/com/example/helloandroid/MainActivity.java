package com.example.helloandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
<<<<<<< HEAD

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
=======
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_NAME = "username";

<<<<<<< HEAD
    // Make welcomeText a class field
    private TextView welcomeText;

    // ActivityResultLauncher for receiving data back from SecondActivity
    private final ActivityResultLauncher<Intent> launcher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    String updatedName = result.getData().getStringExtra("updatedName");

                    if (updatedName != null) {
                        welcomeText.setText("Welcome back, " + updatedName + "!");
                        Toast.makeText(this, "Welcome message updated from Second Screen!", Toast.LENGTH_SHORT).show();
                    }
                }
            });


=======
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
        // UI components
        welcomeText = findViewById(R.id.welcomeText); // FIXED: assign to class field
        EditText nameInput = findViewById(R.id.nameInput);
        Button saveButton = findViewById(R.id.saveButton);
        Button clearButton = findViewById(R.id.clearButton);
        Button nextButton = findViewById(R.id.nextButton);

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String savedName = prefs.getString(KEY_NAME, null);

        // Load saved name if it exists
        if (savedName != null) {
            welcomeText.setText("Welcome back, " + savedName + "!");
        } else {
            welcomeText.setText(R.string.msg_welcome);
        }

        // SAVE button
=======
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
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
        saveButton.setOnClickListener(saveView -> {
            String name = nameInput.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
                return;
            }

<<<<<<< HEAD
=======
            // Save name to SharedPreferences
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
            prefs.edit().putString(KEY_NAME, name).apply();
            welcomeText.setText("Hello, " + name + "!");
            Toast.makeText(this, "Name saved!", Toast.LENGTH_SHORT).show();
        });

<<<<<<< HEAD
        // CLEAR button
        clearButton.setOnClickListener(clearView -> {
            prefs.edit().remove(KEY_NAME).apply();
            welcomeText.setText(R.string.msg_welcome);
            nameInput.setText("");
            Toast.makeText(this, "Data cleared", Toast.LENGTH_SHORT).show();
        });

        // NEXT button (your requested code integrated!)
        nextButton.setOnClickListener(v -> {
            String name = prefs.getString(KEY_NAME, null);

            if (name == null) {
                Toast.makeText(this, "Please save a name first", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("username", name);

            // Use ActivityResultLauncher to open the next screen
            launcher.launch(intent);
        });
    }
}
=======
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
>>>>>>> a95e0cf7c593d1c36ca065a739ca028d3b98152e
