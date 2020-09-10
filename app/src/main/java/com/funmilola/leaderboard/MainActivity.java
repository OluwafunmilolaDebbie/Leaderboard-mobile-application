package com.funmilola.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telecom.Call;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    TabLayout mTabLayout;
    TabItem learningLeader;
    TabItem skillIQLeader;
    ViewPager mViewPager;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    RecyclerView mRecyclerView;
    public static Context sContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LEADERBOARD");

        sContext = getApplicationContext();
        mTabLayout = findViewById(R.id.tabLayout);


        learningLeader = findViewById(R.id.learning_leader);

        skillIQLeader = findViewById(R.id.skill_iq_leader);
        mViewPager = findViewById(R.id.viewPager);



        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),
                mTabLayout.getTabCount(), sContext);
        mViewPager.setAdapter(pagerAdapter);



    }

    public void submitProject(View view) {
        Intent intent = new Intent(getApplicationContext(), SubmitActivity.class);
        startActivity(intent);
    }



}