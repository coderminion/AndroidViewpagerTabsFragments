package com.coderminion.tablayout.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.coderminion.tablayout.R;
import com.coderminion.tablayout.fragments.DanyFragment;
import com.coderminion.tablayout.fragments.JonFragment;
import com.coderminion.tablayout.fragments.TyrionFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    CustumTabsPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = tabLayout.getSelectedTabPosition();

                Snackbar.make(view, "Tab "+tabLayout.getTabAt(i).getText().toString()+" is selected.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        adapter = new CustumTabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager,true);



    }

    public class CustumTabsPagerAdapter extends FragmentPagerAdapter {

        public CustumTabsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    JonFragment jonFragment = new JonFragment();
                    return jonFragment;
                case 1:
                    DanyFragment danyFragment = new DanyFragment();
                    return danyFragment;
                case 2:
                    TyrionFragment tyrionFragment = new TyrionFragment();
                    return tyrionFragment;
            }
            return null;
        }

        @Override
        public int getCount() {

            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "JON SNOW";
                case 1: return "DAENERYS";
                case 2: return "TYRION";
            }
            return null;
        }
    }
}
