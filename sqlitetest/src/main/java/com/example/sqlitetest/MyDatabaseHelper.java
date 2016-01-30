package com.example.sqlitetest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by WWW on 2016/1/30.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_BOOK = "create table Book("
            +"id integer primary key autoincrement,"
            +"author text ,"
            +"price real ,"
            +"pages integer ,"
            +"name text,"
            +"category_id integer)";

    public static final String CREATE_CATEGORY = "create table Category("
            +"id integer primary key autoincrement,"
            +"category_name text ,"
            +"category_code integer)";

    private Context mContext;
    public MyDatabaseHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory,
                            int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);//执行建表语句
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //实现数据库升级
//        sqLiteDatabase.execSQL("drop table if exists Book//");
//        sqLiteDatabase.execSQL("drop table if exists Category//");
//        onCreate(sqLiteDatabase);
        switch (i){
            case 1:
                sqLiteDatabase.execSQL(CREATE_CATEGORY);
            case 2:
                sqLiteDatabase.execSQL("alter table Book add column category_id integer");
            default:
        }
    }
}
