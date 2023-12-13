package com.example.insertdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBH extends SQLiteOpenHelper {
    public static final String DB_name = "db";

    public static final String Table_name = "student_table";

    public static final String column_1 = "Id";

    public static final String column_2 = "Name";

    public static final String column_3 = "surname";

    public DBH(Context context) {
        super(context, DB_name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        db.execSQL("create table "+Table_name+"(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, surname TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);
    }

    public boolean insertData(String Name, String surname) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(column_2, Name);

        cv.put(column_3,surname);


        long result= db.insert(Table_name,null,cv);

        if(result== -1)

            return false;

        else

            return true;
    }
}
