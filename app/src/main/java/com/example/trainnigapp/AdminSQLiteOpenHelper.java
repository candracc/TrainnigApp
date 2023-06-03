package com.example.trainnigapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase Trainning) {
      // Trainning.execSQL("DROP TABLE IF EXISTS usuario");
        Trainning.execSQL("create table usuario(id integer not null primary key autoincrement,nombres text, apellidop text, correo text,descripcion text, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Trainning, int oldVersion, int newVersion) {

    }
}
