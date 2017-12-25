package com.example.srinivas.smmacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by srinivas on 12/20/17.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUsers;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Seva Mandal Macs");
        toolbar.setLogo(R.mipmap.ic_launcher);
        setSupportActionBar(toolbar);

        btnUsers = (Button)findViewById(R.id.btnUsers);
        btnUsers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent userIntent = new Intent (HomeActivity.this,UserActivity.class);
        startActivity(userIntent);
    }
}
