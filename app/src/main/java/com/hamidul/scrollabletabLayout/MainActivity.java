package com.hamidul.scrollabletabLayout;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(),TabAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        adapter.addFragment(new Fragment1(),"Title 1");
        adapter.addFragment(new Fragment2(),"Title 2");
        adapter.addFragment(new Fragment3(),"Title 3");
        adapter.addFragment(new Fragment1(),"Title 4");
        adapter.addFragment(new Fragment2(),"Title 5");
        adapter.addFragment(new Fragment3(),"Title 6");
        adapter.addFragment(new Fragment1(),"Title 7");
        adapter.addFragment(new Fragment2(),"Title 8");
        adapter.addFragment(new Fragment3(),"Title 9");
        adapter.addFragment(new Fragment1(),"Title 10");
        adapter.addFragment(new Fragment2(),"Title 11");
        adapter.addFragment(new Fragment3(),"Title 12");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    public class TabAdapter extends FragmentPagerAdapter{

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        ArrayList<String> fragmentTitle = new ArrayList<>();

        public TabAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title){
            fragmentArrayList.add(fragment);
            fragmentTitle.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
    }



}