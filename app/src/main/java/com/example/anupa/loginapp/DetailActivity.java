package com.example.anupa.loginapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DetailActivity extends AppCompatActivity {

    private EditText User_email;
    private Button btLogin;
    private FirebaseAuth fireBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        User_email=(EditText) findViewById(R.id.etEmail2);
        btLogin=(Button) findViewById(R.id.btLogin);
        fireBase=FirebaseAuth.getInstance();
        FirebaseUser user=fireBase.getCurrentUser();
        final String abc="Qwerty12345";







        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(User_email.getText().toString().isEmpty())
                {
                    Toast.makeText(DetailActivity.this,"Please enter the email",Toast.LENGTH_SHORT).show();
                }

                fireBase.signInWithEmailAndPassword(User_email.getText().toString(),abc).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            checkEmailVerification();

                        }
                    }
                });
            }
        });

    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser=fireBase.getInstance().getCurrentUser();
        Boolean emailflag=firebaseUser.isEmailVerified();

        if(emailflag)
        {
           startActivity(new Intent(DetailActivity.this,SubmitActivity.class));
            finish();
        }
        else
        {
            Toast.makeText(DetailActivity.this,"Not allowed for Vote",Toast.LENGTH_SHORT).show();
            fireBase.signOut();

        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.adminMenu: {
                startActivity(new Intent(DetailActivity.this, adminLogin.class));
                break;
            }

            case R.id.resultMenu:{
                startActivity(new Intent(DetailActivity.this,result.class));
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
