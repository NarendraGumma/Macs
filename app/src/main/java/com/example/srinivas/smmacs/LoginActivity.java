package com.example.srinivas.smmacs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by srinivas on 12/18/17.
 */

public class LoginActivity extends Activity implements View.OnClickListener {
    EditText etUsername,etPassword;
    Button btnLogin;
    TextView tvForgot;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin   = (Button)findViewById(R.id.btnLogin);
        tvForgot   = (TextView)findViewById(R.id.tvForgot);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(loginIntent);
    }
}
