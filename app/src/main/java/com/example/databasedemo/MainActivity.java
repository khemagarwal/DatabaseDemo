package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.sql.SQLData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase sqLiteDatabase=this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
            sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newusers (id INTEGER PRIMARY KEY,name VARCHAR,age INT(3))");

//        sqLiteDatabase.execSQL("INSERT INTO newusers (name,age) VALUES ('Khem',20)");
//        sqLiteDatabase.execSQL("INSERT INTO newusers (name,age) VALUES ('Khedu',23)");
//            sqLiteDatabase.execSQL("INSERT INTO newusers (name,age) VALUES ('kalyan',12)");

            sqLiteDatabase.execSQL( "DELETE FROM newusers  WHERE id= 3");

            Cursor c=sqLiteDatabase.rawQuery("SELECT * FROM newusers",null);

            int nameIndex=c.getColumnIndex("name");
            int ageIndex=c.getColumnIndex("age");
            int idIndex=c.getColumnIndex("id");

            c.moveToFirst();

            while( !c.isAfterLast())

            {
                Log.i("name",c.getString(nameIndex));
                Log.i("age",c.getString(ageIndex));
                Log.i("id",c.getString(idIndex));

                c.moveToNext();
            }
        }catch (Exception e)
        {
            e.printStackTrace();

        }



    }
}
