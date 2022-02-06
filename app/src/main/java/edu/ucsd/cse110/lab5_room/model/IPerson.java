package edu.ucsd.cse110.lab5_room.model;

//public interface IPerson {
//    String getName();
//    String[] getNotes();
//}

import java.util.List;

//public abstract class IPerson {
//    public abstract String getName();
//    public abstract List< String> getNotes();
//}

public interface IPerson {

    int getID();
    String getName();
    List< String> getNotes();
}