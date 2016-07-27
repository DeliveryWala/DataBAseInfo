package com.example.arif.databaseinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arif on 26/07/16.
 */
public class DatabaseAdapter {
    DatabaseHelper helper;

    public DatabaseAdapter(Context context) {
        helper=new DatabaseHelper(context);

    }
    public long insertData(String fName, String lName, String batch)
    {
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues cValues= new ContentValues();
        cValues.put(DatabaseHelper.FNAME,fName);
        cValues.put(DatabaseHelper.LNAME,lName);
        cValues.put(DatabaseHelper.BATCH,batch);
        long id=db.insert(DatabaseHelper.TABLE_NAME,null,cValues);
        return id;
    }
    public List<Data> showAllData()
    {
        List<Data> data= new ArrayList<Data>();
        String selectQuery=" SELECT * FROM "+DatabaseHelper.TABLE_NAME;
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        Data list;
        if(cursor.moveToFirst()){
            do{
                 list=new Data();
                list.setfName(cursor.getString(1));
                list.setlName(cursor.getString(2));
                list.setBatch(cursor.getString(3));
                data.add(list);
            }while(cursor.moveToNext());
        }
        return data;
    }


    static class DatabaseHelper extends SQLiteOpenHelper {
        private static String DATABASE_NAME = "StudentDatabase";
        private static String TABLE_NAME = "StudentTable";
        private static int DATABASE_VERSION = 8;
        private static String FNAME = "Name";
        private static String UID = "_id";
        private Context context;
        private static String LNAME = "LastName";
        private static String BATCH = "Batch";
        private static String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FNAME + " TEXT, " + LNAME + " TEXT, " + BATCH + " TEXT);";
        private static String DROP_TABLE = " DROP TABLE IF EXISTS " + TABLE_NAME;

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
            Message.message(context, "Constuctor was called");
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
                Message.message(context, "onCreate was called");
            } catch (SQLException e) {
                Message.message(context, " " + e);
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
                Message.message(context, "onUpgrade was called");
            } catch (SQLException e) {
                Message.message(context, " " + e);
            }

        }
    }
}