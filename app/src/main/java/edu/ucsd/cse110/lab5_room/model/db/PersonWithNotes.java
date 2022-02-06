package edu.ucsd.cse110.lab5_room.model.db;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

//import edu.ucsd.cse110.lab5ref.model.IPerson;
import edu.ucsd.cse110.lab5_room.model.IPerson;

public class PersonWithNotes implements IPerson {

    @Embedded
    public Person person;

//    public PersonWithNotes(int id, String name, List< String> notes) {
//        this.person.personId = id;
//        this.person.name = name;
//        this.notes = notes;
//    }

    @Relation(parentColumn = "id",
        entityColumn = "person_id",
        entity = Note.class,
        projection = {"text"})
    public List<String> notes;

    @Override
    public int getID() {
        return this.person.personId;
    }

    @Override
    public String getName(){
        return this.person.name;
    }

    @Override
    public List< String> getNotes(){
        return this.notes;
    }

}
