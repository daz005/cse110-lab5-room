package edu.ucsd.cse110.lab5_room.model;

import java.util.List;

public class DummyPerson implements IPerson {

    private final int id;
    private final String name;
    private final List< String> notes;

    public DummyPerson(int id, String name, List< String> notes) {
        this.id = id;
        this.name = name;
        this.notes = notes;
    }

    @Override
    public int getID() { return id;};

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List< String> getNotes() {
        return notes;
    }
}
