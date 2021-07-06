package com.example.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguide.HelperClass.SliderAdapter;
import com.example.cityguide.R;
import com.example.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearLayout;

    private SliderAdapter sliderAdapter;
    private TextView[] dots;
    Animation animation;
    private Button lestGetStarted;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        viewPager = findViewById(R.id.slider);
        linearLayout = findViewById(R.id.dots);
        lestGetStarted = findViewById(R.id.get_started_btn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addDots(int position) {
        dots = new TextView[4];
        linearLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.black));

            linearLayout.addView(dots[i]);


        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.purple_700));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);

            currentPosition = position;

            if (position == 0) {
                lestGetStarted.setVisibility(View.INVISIBLE);
            } else if (position == 1) {
                lestGetStarted.setVisibility(View.INVISIBLE);
            } else if (position == 2) {
                lestGetStarted.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                lestGetStarted.setAnimation(animation);
                lestGetStarted.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skip(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPosition + 1);
    }
}