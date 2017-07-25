package com.example.kamonwan.mvcstructure.activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.kamonwan.mvcstructure.R;
import com.example.kamonwan.mvcstructure.fragment.MainFragment;
import com.example.kamonwan.mvcstructure.util.ScreenUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int screenWidth = ScreenUtil.getInstance().getScreenWidth();
        int screenHeight = ScreenUtil.getInstance().getScreenHeight();

        //Toast screenWidth & screenHeight

        //Separate by Android Version
        if (Build.VERSION.SDK_INT >= 21) {
            // Run on Android 21+
        } else {
            // Run on Android 1-20
        }

        if (savedInstanceState == null) {
            //First Create
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance(123)
                            ,"MainFragment")
                    .commit();


        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woo Hoo");
        }
    }
}
