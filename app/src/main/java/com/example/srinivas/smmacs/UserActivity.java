package com.example.srinivas.smmacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by chakravarthy on 22/12/17.
 */

public class UserActivity extends Activity implements View.OnClickListener {

    Button btnAddUser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list_layout);
        btnAddUser = (Button)findViewById(R.id.btnAddUser);

        btnAddUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent addIntent = new Intent(UserActivity.this,AddUserActivity.class);
        startActivity(addIntent);
    }
}
