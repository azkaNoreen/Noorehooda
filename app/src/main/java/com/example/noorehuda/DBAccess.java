package com.example.noorehuda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBAccess {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private static DBAccess instance;
    Cursor c=null;

    private DBAccess(Context context){
        this.sqLiteOpenHelper=new DBOpenHelper(context);
    }
    public static DBAccess getInstance(Context context){
        if(instance==null){
            instance=new DBAccess(context);
        }
        return instance;
    }
    public void open(){
        this.sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();

    }
    public void close(){
       if(sqLiteDatabase!=null){
           this.sqLiteDatabase.close();
       }

    }
//    public ArrayList<String> getSurahnTrans() {
//
//        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
//
//        Cursor cursorCourses = db.rawQuery("SELECT * FROM tayah" , null);
//
//        ArrayList<String> todoArrayList = new ArrayList<>();
//
//        // moving our cursor to first position.
//        if (cursorCourses.moveToFirst()) {
//            do {
//
//                todoArrayList.add(cursorCourses.getString(4));
//            } while (cursorCourses.moveToNext());
//        }
//        cursorCourses.close();
//        return todoArrayList;
//    }
    public ArrayList<PairString> getSurahAyahs(int Surah_no)
    {
                SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

        c=db.rawQuery("Select ArabicText,FatehMuhammadJalandhri,DrMohsinKhan from tayah where SuraID = "+Surah_no+"",new String[]{});
        ArrayList<PairString> SurahAyahs=new ArrayList<>();
        PairString ayahs;
        while(c.moveToNext()){
            String ayah=c.getString(0);
            String urduTranslatiom=c.getString(1);
            String englishTranslation=c.getString(2);
            ayahs=new PairString(ayah,urduTranslatiom,englishTranslation);
            SurahAyahs.add(ayahs);
        }
        return SurahAyahs;
    }
    public ArrayList<PairString> getParahAyahs(int Parah_no)
    {
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

        c=db.rawQuery("Select ArabicText,FatehMuhammadJalandhri,DrMohsinKhan from tayah where ParaID = "+Parah_no+"",new String[]{});
        ArrayList<PairString> SurahAyahs=new ArrayList<>();
        PairString ayahs;
        while(c.moveToNext()){
            String ayah=c.getString(0);
            String urduTranslatiom=c.getString(1);
            String englishTranslation=c.getString(2);
            ayahs=new PairString(ayah,urduTranslatiom,englishTranslation);
            SurahAyahs.add(ayahs);
        }
        return SurahAyahs;
    }

}

