package com.riotfallen.myflexiblefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();

        Fragment fragment = fragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());
        if(!(fragment instanceof HomeFragment)) {
            fragmentTransaction.add(R.id.frameLayoutContainer, homeFragment, HomeFragment.class.getSimpleName());

            Log.d("MyFlexibleFragment", "Fragment Name: " + HomeFragment.class.getSimpleName());
            fragmentTransaction.commit();
        }
    }
}
