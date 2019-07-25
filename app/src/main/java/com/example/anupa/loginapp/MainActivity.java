package com.example.anupa.loginapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText User_email;
    private Button btSigin;
    private FirebaseAuth firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User_email=(EditText) findViewById(R.id.etEmail2);
        btSigin=(Button) findViewById(R.id.btSign);
        firebase=FirebaseAuth.getInstance();
       final String str="Qwerty12345";

        btSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    firebase.createUserWithEmailAndPassword(User_email.getText().toString(),str).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                            sendEmailVerification();
                            }
                            else
                            {
                                Toast.makeText(MainActivity.this,"Login failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            }
        });


    }
    private void sendEmailVerification()
    {
        FirebaseUser firebaseUser=firebase.getCurrentUser();
        if(firebaseUser!=null)
        {
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this,"Verification mail is sent",Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }

}
