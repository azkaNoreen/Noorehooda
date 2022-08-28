package com.example.noorehuda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBOpenHelper extends SQLiteAssetHelper {

    private static final String DB_NAME="quran_database.db";
    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
}
