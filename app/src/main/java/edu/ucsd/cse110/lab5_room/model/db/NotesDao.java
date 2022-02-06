package edu.ucsd.cse110.lab5_room.model.db;


import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface NotesDao {
    @Transaction
    @Query("SELECT * FROM notes where person_id=:personId")
    List<Note> getForPerson(int personId);

    @Query("SELECT * FROM notes where id=:id")
    Note get(int id);

    @Query("SELECT COUNT(*) from notes")
    int count();

}
