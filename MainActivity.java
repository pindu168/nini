package com.pindu.nini.ui.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.pindu.nini.R;
import com.pindu.nini.adapter.MainPageAdapter;
import com.pindu.nini.base.BaseActivity;
import com.pindu.nini.global.Constant;
import com.pindu.nini.ui.fragment.CommunityFragment;
import com.pindu.nini.ui.fragment.HomeFragment;
import com.pindu.nini.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private List<Fragment> fragments;
    private MainPageAdapter adapter;
    private LinearLayout llMainHome;
    private LinearLayout llMainCommunity;
    private LinearLayout llMainMine;


    @Override
    public void initView() {
        setContentView(R.layout.activity_main);

        //屏蔽输入法自动弹出
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        viewPager = (ViewPager) findViewById(R.id.vp_main);
        llMainCommunity = (LinearLayout) findViewById(R.id.ll_main_community);
        llMainHome = (LinearLayout) findViewById(R.id.ll_main_home);
        llMainMine = (LinearLayout) findViewById(R.id.ll_main_mine);

    }

    @Override
    public void initListener() {

        llMainCommunity.setOnClickListener(this);
        llMainHome.setOnClickListener(this);
        llMainMine.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滑动过程中调用
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //滑动完成后调用
            @Override
            public void onPageSelected(int position) {
                setPageIcon();
            }
            //
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //页面切换后更换图片与文字颜色
    private void setPageIcon() {

    }

    @Override
    public void initData() {

        fragments = new ArrayList<Fragment>();
        //创建Fragment对象，存入集合
        CommunityFragment communityFragment = new CommunityFragment();
        HomeFragment homeFragment = new HomeFragment();
        MineFragment mineFragment = new MineFragment();
        //存放的顺序不能乱
        fragments.add(homeFragment);
        fragments.add(communityFragment);
        fragments.add(mineFragment);
        adapter = new MainPageAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void processClick(View view) {

        switch (view.getId()){

            case R.id.ll_main_home:
                viewPager.setCurrentItem(Constant.Main.HOMEPAGE);
                break;
            case R.id.ll_main_community:
                viewPager.setCurrentItem(Constant.Main.COMMUNITYPAGE);
                break;
            case R.id.ll_main_mine:
                viewPager.setCurrentItem(Constant.Main.MINEPAGE);
                break;
        }

    }
}
