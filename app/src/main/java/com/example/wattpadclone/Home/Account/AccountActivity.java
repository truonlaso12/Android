package com.example.wattpadclone.Home.Account;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.wattpadclone.Home.Account.Thietlap.thiet_lap_chung;
import com.example.wattpadclone.Home.Adapters.SectionsPageAdapter;
import com.example.wattpadclone.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
public class AccountActivity extends AppCompatActivity {
    private BottomSheetBehavior mBottomSheetBehavior;
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;
    private RelativeLayout hasReadLayout, followersLayout;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
<<<<<<< HEAD
=======
        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator);
        RelativeLayout relativeLayout = findViewById(R.id.relaAccount);

>>>>>>> e60429fe3e3bb5cd42b14cfeec16d288f75783ce
        Toolbar toolbar = findViewById(R.id.toolbar_account);
        toolbar.inflateMenu(R.menu.menu_toolbar_account);

        toolbar.setLogo(ContextCompat.getDrawable(this, R.drawable.ic_baseline_arrow_back_white_24));
        View logoView = toolbar.getChildAt(2);
        logoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.toolbar_acc_setting)
                {
                    Intent intent = new Intent(AccountActivity.this, thiet_lap_chung.class);
                    startActivity(intent);
                }
                return false;
            }
        });

        View bottomSheet = findViewById(R.id.acc_bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        coordinatorLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                coordinatorLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                mBottomSheetBehavior.setPeekHeight(coordinatorLayout.getHeight()- relativeLayout.getHeight());
            }
        });

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.acc_viewPager);
        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.acc_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FF5722"));
        tabLayout.setTabTextColors(Color.parseColor("#000000"), Color.parseColor("#000000"));

        hasReadLayout = findViewById(R.id.hasRead);
        followersLayout = findViewById(R.id.followers);

        hasReadLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Account_intro(), "Giới thiệu");
        adapter.addFragment(new Account_message(), "Cuộc hội thoại");
        viewPager.setAdapter(adapter);
    }
}