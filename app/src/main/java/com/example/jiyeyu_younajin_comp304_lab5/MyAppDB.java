package com.example.jiyeyu_younajin_comp304_lab5;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities =
        {
                Restaurant.class,
                Cuisine.class
        },
        version = 1)

public abstract class MyAppDB extends RoomDatabase {

    private static final String dbName = "myDB";
    private static MyAppDB myappdb;

    public static synchronized  MyAppDB getMyAppDB (Context context)

    {

        if (myappdb == null){
            myappdb = Room.databaseBuilder(context, MyAppDB.class, dbName)
                    .fallbackToDestructiveMigration().build();
        }

        return myappdb;

    }
    public abstract MyDao myDao();
}
