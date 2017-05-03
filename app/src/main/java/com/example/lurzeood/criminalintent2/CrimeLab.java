package com.example.lurzeood.criminalintent2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import database.CrimeDbSchema.CrimeDbSchema.CrimeTable;
import database.CrimeDbSchema.CrimebaseHelper;

/**
 * Created by Lurzeood on 2017/4/25 0025.
 */

public class CrimeLab {

    private static CrimeLab sCrimeLab;

    private Context mContext;

    private SQLiteDatabase mDatabase;


    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context){
        mContext = context.getApplicationContext();
        mDatabase = new CrimebaseHelper(mContext).getWritableDatabase();
    }

    public List<Crime> getCrimes(){
        return new ArrayList<>();
    }

    public Crime getCrime(UUID id){

        return null;
    }

    public void addCrime(Crime c){

        ContentValues values = getContentValues(c);

        mDatabase.insert(CrimeTable.NAME,null,values);
    }

    public void updateCrime(Crime crime){
        String uuidString = crime.getId().toString();
        ContentValues values = getContentValues(crime);
        mDatabase.update(CrimeTable.NAME,values,CrimeTable.Cols.UUID + " = ?",new String[]{uuidString});
    }

    private static ContentValues getContentValues(Crime crime){
        ContentValues values = new ContentValues();
        values.put(CrimeTable.Cols.UUID,crime.getId().toString());
        values.put(CrimeTable.Cols.TITLE,crime.getTitle());
        values.put(CrimeTable.Cols.DATE,crime.getDate().getTime());
        values.put(CrimeTable.Cols.SOLVED,crime.isSolved()?1:0);

        return values;
    }

}
