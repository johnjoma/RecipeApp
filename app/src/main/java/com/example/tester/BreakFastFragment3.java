package com.example.tester;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class BreakFastFragment3 extends AppCompatActivity {

    private Toolbar mToolBar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break_fast_fragment3);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        mToolBar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.viewPager);


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            mToolBar.setTitle(getString(R.string.breakRecipeTitle3));
            mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intBreak = new Intent(BreakFastFragment3.this,BreakFast.class);
                    startActivity(intBreak);
                }
            });
        }

        setupViewpager(mViewPager);

        mTabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewpager(ViewPager viewPager){

        viewPagerAdapter adapter = new viewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BreakFastIngredients3(),"Ingredients");
        adapter.addFragment(new BreakFastProcedure3(),"Procedure");
        adapter.addFragment(new BreakFastCredit3(),"Credit");


        viewPager.setAdapter(adapter);


    }
    class viewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private  final  List<String> mFragmentTitleList = new ArrayList<>();





        public viewPagerAdapter(FragmentManager fm ){

            super(fm);



        }

        @Override
        public Fragment getItem(int i) {
            return mFragmentList.get(i);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }


        public void addFragment (Fragment fragment, String title){

            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);


        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}
