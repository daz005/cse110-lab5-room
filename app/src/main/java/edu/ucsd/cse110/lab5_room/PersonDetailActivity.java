package edu.ucsd.cse110.lab5_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import edu.ucsd.cse110.lab5_room.model.IPerson;
import edu.ucsd.cse110.lab5_room.model.db.AppDatabase;
import edu.ucsd.cse110.lab5_room.model.db.Note;

public class PersonDetailActivity extends AppCompatActivity {

    private AppDatabase db;
    private IPerson person;

    private RecyclerView notesRecyclerView;
    private RecyclerView.LayoutManager notesLayoutManger;
    private NotesViewAdapter notesViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        Intent intent = getIntent();
        int personId = intent.getIntExtra("person_id", 0);

        db = AppDatabase.getSingleton(this);
        person = db.personsWithNotesDao().get(personId);
        List<Note>  notes = db.notesDao().getForPerson(personId);

        //set the title with the person
        setTitle(person.getName());

        //set up the recycler view to show our database contents
        notesRecyclerView = findViewById(R.id.notes_view);
        notesLayoutManger = new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(notesLayoutManger);

        notesViewAdapter =  new NotesViewAdapter(notes);
        notesRecyclerView.setAdapter(notesViewAdapter);

    }

    public void onGoBackClicked(View view) {
        finish();
    }
}