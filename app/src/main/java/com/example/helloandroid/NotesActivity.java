package com.example.helloandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloandroid.data.AppDatabase;
import com.example.helloandroid.data.Note;
import java.util.List;
import java.util.concurrent.Executors;

public class NotesActivity extends AppCompatActivity {

    private NoteAdapter adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        db = AppDatabase.getInstance(this);

        EditText titleInput = findViewById(R.id.noteTitle);
        EditText contentInput = findViewById(R.id.noteContent);
        Button saveButton = findViewById(R.id.saveNote);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter();
        recyclerView.setAdapter(adapter);

        saveButton.setOnClickListener(v -> {
            String title = titleInput.getText().toString().trim();
            String content = contentInput.getText().toString().trim();
            if (!title.isEmpty()) {
                Executors.newSingleThreadExecutor().execute(() -> {
                    db.noteDao().insert(new Note(title, content));
                });
                titleInput.setText("");
                contentInput.setText("");
            }
        });

        db.noteDao().getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
    }
}