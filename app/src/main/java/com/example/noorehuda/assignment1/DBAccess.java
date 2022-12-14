package com.example.noorehuda.assignment1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.noorehuda.assignment2.VerseAndTranslation;

import java.util.ArrayList;

public class DBAccess {
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    private static DBAccess instance;
    Cursor c=null;
    private QDH qdh=new QDH();

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
    public ArrayList<VerseAndTranslation> getSurahAyahs(int Surah_no,String TranslatorName)
    {
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

        c=db.rawQuery("Select ArabicText,"+TranslatorName+" from tayah where SuraID = "+Surah_no+" ORDER BY AyaID,SuraID,AyaNo",new String[]{});
        ArrayList<VerseAndTranslation> SurahAyahs=new ArrayList<>();
        VerseAndTranslation ayahs;
        while(c.moveToNext()){
            String ayah=c.getString(0);
            String Translation=c.getString(1);
            ayahs=new VerseAndTranslation(ayah,Translation);
            SurahAyahs.add(ayahs);
        }
        return SurahAyahs;
    }
    public ArrayList<VerseAndTranslation> getParahAyahs(int Parah_no,String TranslatorName)
    {
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

        c=db.rawQuery("Select ArabicText,"+TranslatorName+" from tayah where ParaID = "+Parah_no+" ORDER BY AyaID,SuraID,AyaNo",new String[]{});
        ArrayList<VerseAndTranslation> ParahAyahs=new ArrayList<>();
        VerseAndTranslation ayahs;
        while(c.moveToNext()){
            String ayah=c.getString(0);
            String Translation=c.getString(1);
            ayahs=new VerseAndTranslation(ayah,Translation);
            ParahAyahs.add(ayahs);
        }
        return ParahAyahs;
    }
    public ArrayList<PairString> getParahAyahs(int Parah_no)
    {
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();

        c=db.rawQuery("Select ArabicText,FatehMuhammadJalandhri,DrMohsinKhan from tayah where ParaID = "+Parah_no+" ORDER BY AyaID,SuraID,AyaNo",new String[]{});
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
    public ArrayList<PairString> searchSurah(String Surah)
    {
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
        int pos=qdh.getSurahID(Surah)+1;

        ArrayList<PairString> SurahAyahs=getSurahAyahs(pos);
        return SurahAyahs;
    }
    public ArrayList<PairString> searchParah(String Parah)
    {
        SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
        int pos=qdh.getParahID(Parah)+1;

        ArrayList<PairString> SurahAyahs=getParahAyahs(pos);
        return SurahAyahs;
    }


}

