package com.arikbidny.techharel;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.arikbidny.techharel.utils.FontManager;

public class MainActivity extends AppCompatActivity {

    FontManager FM;
    EditText username,password;
    Button signIn;
    TextView logo,forgotPassword,register,signinhint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FM=new FontManager(getApplicationContext());
        InitUI();
        ActionBar("");
    }

    public void InitUI(){

        logo=(TextView)findViewById(R.id.logo);
        username=(EditText)findViewById(R.id.usernameedt);
        password=(EditText)findViewById(R.id.passwordedt);
        signIn=(Button)findViewById(R.id.signinbtn);
        forgotPassword=(TextView)findViewById(R.id.forgotpasswordtv);
        signinhint=(TextView)findViewById(R.id.signinhint);
        register=(TextView)findViewById(R.id.registertv);

        FM.setAppRegular(logo);
        FM.setAppMedium(username);
        FM.setAppMedium(password);
        FM.setAppMedium(signIn);
        FM.setAppMedium(forgotPassword);
        FM.setAppMedium(signinhint);
        FM.setAppMedium(register);

    }


    public void ActionBar(String title) {


        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        RelativeLayout actionBarLayout = (RelativeLayout) getLayoutInflater().inflate(R.layout.actionbar_back, null);
        actionBarLayout.setBackgroundColor(Color.parseColor("#38b2e4"));
        TextView actionBarTitleview = (TextView) actionBarLayout.findViewById(R.id.actionbar_titleview);
        TextView backicon = (TextView) actionBarLayout.findViewById(R.id.backicon);
        actionBarTitleview.setText(title);
        backicon.setTextColor(Color.parseColor("#ffffff"));

        backicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

//        Setting Custom font

        FM.setAppMedium(actionBarTitleview);
        FM.setBackIcon(backicon);

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT,
                Gravity.LEFT);

        actionBar.setCustomView(actionBarLayout, params);
        actionBar.setDisplayHomeAsUpEnabled(false);

    }

}
