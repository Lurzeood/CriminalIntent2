package com.example.lurzeood.criminalintent2;

import android.support.v4.app.Fragment;

public class CrimeActivity extends SinglefragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
