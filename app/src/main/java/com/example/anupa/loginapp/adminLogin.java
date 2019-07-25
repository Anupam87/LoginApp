package com.example.anupa.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class adminLogin extends AppCompatActivity {


    private Button LogIn;
    private EditText adminID,adminPswrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        valide();

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(adminLogin.this,MainActivity.class));
                finish();
            }
        });
    }

    public  void valide(){
        LogIn=(Button) findViewById(R.id.btAdLogin);
        adminID=(EditText) findViewById(R.id.etAdminID);
        adminPswrd=(EditText) findViewById(R.id.etAdminpswrd);
    }
}
