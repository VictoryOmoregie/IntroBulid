package com.example.helloandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserPrefs";
    private static final String KEY_NAME = "username";

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        saveButton.setOnClickListener(saveView -> {
            String name = nameInput.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show();
                return;
            }

            prefs.edit().putString(KEY_NAME, name).apply();
            welcomeText.setText("Hello, " + name + "!");
            Toast.makeText(this, "Name saved!", Toast.LENGTH_SHORT).show();
        });

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
