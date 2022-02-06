package edu.ucsd.cse110.lab5_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import edu.ucsd.cse110.lab5_room.model.DummyPerson;
import edu.ucsd.cse110.lab5_room.model.IPerson;
import edu.ucsd.cse110.lab5_room.model.db.AppDatabase;

public class MainActivity extends AppCompatActivity {
    protected RecyclerView personsRecyclerView;
    protected RecyclerView.LayoutManager personsLayoutManager;
    protected PersonsViewAdapter personsViewAdapter;

    protected IPerson[] data = {
            new DummyPerson(1,"Jane Doe", Arrays.asList(new String[]{
                    "Likes cats.",
                    "Favorite color is blue."
            })),
            new DummyPerson(2, "John Public", Arrays.asList(new String[]{
                    "Likes dogs.",
                    "Favorite color is red."
            })),
            new DummyPerson(3, "Richard Roe", Arrays.asList(new String[]{
                    "Likes birds.",
                    "Favorite color is yellow."
            })),

            new DummyPerson(4,"Derek Zhu", Arrays.asList(new String[]{
                    "Likes Hiking",
                    "Favorite color is orange."
            })),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.app_title);

        AppDatabase db = AppDatabase.getSingleton(getApplicationContext());
        List<? extends IPerson> persons= db.personsWithNotesDao().getAll();

        // Set up the recycler view to view our database contents.
        personsRecyclerView = findViewById(R.id.persons_view);

        personsLayoutManager = new LinearLayoutManager(this);
        personsRecyclerView.setLayoutManager(personsLayoutManager);

        personsViewAdapter = new PersonsViewAdapter(persons);

        personsRecyclerView.setAdapter(personsViewAdapter);
    }
}