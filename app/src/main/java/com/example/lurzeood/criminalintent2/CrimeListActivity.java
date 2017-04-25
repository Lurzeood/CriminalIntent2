package com.example.lurzeood.criminalintent2;

import android.support.v4.app.Fragment;

/**
 * Created by Lurzeood on 2017/4/25 0025.
 */

public class CrimeListActivity extends SinglefragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
