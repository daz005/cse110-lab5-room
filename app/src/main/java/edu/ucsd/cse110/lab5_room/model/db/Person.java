package edu.ucsd.cse110.lab5_room.model.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import edu.ucsd.cse110.lab5_room.model.IPerson;


@Entity(tableName = "persons")
public class Person  {

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int personId;

    @ColumnInfo(name = "name")
    public String name;

}
