package edu.ucsd.cse110.lab5_room.model.db;


import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PersonsWithNotesDao {

    @Transaction
    @Query("SELECT * FROM persons")
    List<PersonWithNotes> getAll();

    @Query("SELECT * FROM persons WHERE id=:id")
    PersonWithNotes get(int id);

    @Query("SELECT COUNT(*) from persons")
    int count();

}
