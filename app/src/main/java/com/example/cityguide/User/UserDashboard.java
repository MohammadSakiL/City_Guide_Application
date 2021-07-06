package com.example.cityguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.cityguide.HelperClass.HomeAdapter.CategoryAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.CategoryHelperClass;
import com.example.cityguide.HelperClass.HomeAdapter.FeaturedAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.FeaturedHelperClass;
import com.example.cityguide.HelperClass.HomeAdapter.MostViewedAdapter;
import com.example.cityguide.HelperClass.HomeAdapter.MostViewedHelperClass;
import com.example.cityguide.R;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    private RecyclerView featuredRecycler, mostViewedRecycler,categoryRecycler;
    private RecyclerView.Adapter feature_adapter,mv_adapter,cat_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        if (Build.VERSION.SDK_INT >= 21) {
//            Window window = this.getWindow();
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.setStatusBarColor(this.getResources().getColor(R.color.lightWhite));
//        }
        setContentView(R.layout.activity_user_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.mv_recycler);
        categoryRecycler = findViewById(R.id.cat_recycler);

        featuredRecycler();
        mostViewedRecycler();
        categoryRecycler();




    }

    private void categoryRecycler() {
        categoryRecycler.hasFixedSize();
        categoryRecycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        ArrayList<CategoryHelperClass> categoryHelperClassArrayList = new ArrayList<>();
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xff9B959A,0xff5A5659});
        GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xff9FA0EE,0xff787AF7});
        GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffF99A9A,0xffF55959});

        categoryHelperClassArrayList.add(new CategoryHelperClass(gradient1 ,R.drawable.nsu,  "Education"));
        categoryHelperClassArrayList.add(new CategoryHelperClass(gradient2 ,R.drawable.resturant,  "Resturant"));
        categoryHelperClassArrayList.add(new CategoryHelperClass(gradient3 ,R.drawable.hospital,  "Hospital"));

        cat_adapter = new CategoryAdapter(categoryHelperClassArrayList);
        categoryRecycler.setAdapter(cat_adapter);

    }

    private void mostViewedRecycler() {

        mostViewedRecycler.hasFixedSize();
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        ArrayList<MostViewedHelperClass> mostViewedHelperClassArrayList = new ArrayList<>();

        mostViewedHelperClassArrayList.add(new MostViewedHelperClass(R.drawable.aiub,"AIUB Campus"," enable JavaScript in your web browser · American International University-Bangladesh"));
        mostViewedHelperClassArrayList.add(new MostViewedHelperClass(R.drawable.night_view,"New Dhaka "," enable JavaScript in your web browser·American International University-Bangladesh"));

        mv_adapter = new MostViewedAdapter(mostViewedHelperClassArrayList);
        mostViewedRecycler.setAdapter(mv_adapter);



    }

    private void featuredRecycler() {
        featuredRecycler.hasFixedSize();
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        ArrayList<FeaturedHelperClass> featuredHelperClassArrayList = new ArrayList<>();

        featuredHelperClassArrayList.add(new FeaturedHelperClass(R.drawable.mc_donald,"McDonald's","on the red bulb icon and then click implement methods."));
        featuredHelperClassArrayList.add(new FeaturedHelperClass(R.drawable.featured_image_1,"Dhaka City","on the red bulb icon and then click implement methods."));
        featuredHelperClassArrayList.add(new FeaturedHelperClass(R.drawable.featured_image_2,"Port city","on the red bulb icon and then click implement methods."));

        feature_adapter = new FeaturedAdapter(featuredHelperClassArrayList);
        featuredRecycler.setAdapter(feature_adapter);
    }
}