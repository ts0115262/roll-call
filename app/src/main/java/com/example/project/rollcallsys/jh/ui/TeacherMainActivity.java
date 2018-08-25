package com.example.project.rollcallsys.jh.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.project.rollcallsys.R;
import com.example.project.rollcallsys.jh.fragment.CheckFragment;
import com.example.project.rollcallsys.jh.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class TeacherMainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    List<Fragment> mFragment = new ArrayList<>();
    List<String> mTitle = new ArrayList<>();
    View view1, view2;
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {
        mViewPager = findViewById(R.id.mViewPager);
        mTabLayout = findViewById(R.id.mTabLayout);
        view1 = View.inflate(this, R.layout.fragment_message, null);
        view2 = View.inflate(this, R.layout.fragment_check, null);

        mFragment.add(new MessageFragment());
        mFragment.add(new CheckFragment());

        mTitle.add("消息");
        mTitle.add("签到");

        //预加载
        mViewPager.setOffscreenPageLimit(mFragment.size());
        //设置适配器
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的Item
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            //返回item的个数
            @Override
            public int getCount() {
                return mFragment.size();
            }


            //设置标题
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }
        });

        //绑定
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
