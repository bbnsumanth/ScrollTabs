package com.slidenerd.exmples.two.scrolltabs;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

    ViewPager pager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
        pager.setAdapter(new MyAdapter(manager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment frag = null;
            if(i==0){
                frag = new FragmentA();
            }
            if(i==1){
                frag = new FragmentB();
            }
            if(i==2){
                frag = new FragmentC();
            }
            return frag;
        }

        @Override
        public int getCount() {
            return 3;
        }
        public CharSequence getPageTitle(int i){
            String title = new String();
            if(i==0){
               title = "FRAG1";
            }
            if(i==1){
                title = "FRAG2";
            }
            if(i==2){
                title = "FRAG3";
            }
            return title;
        }
    }
}
