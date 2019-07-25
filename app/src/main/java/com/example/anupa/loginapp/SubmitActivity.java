package com.example.anupa.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SubmitActivity extends AppCompatActivity {

    private EditText UserName,UserPhno,UserDob;
    private Button submit;
    String UsName,UsPhno,UsDob;
    private ImageView pro;
    private Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        valide();
        UsName=UserName.getText().toString();
        UsPhno=UserPhno.getText().toString();
        UsDob=UserDob.getText().toString();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(sendUserData()){

               startActivity(new Intent(SubmitActivity.this,Candidate.class));
               finish();
            }
            else
            {
                Toast.makeText(SubmitActivity.this,"Failed to send the data",Toast.LENGTH_SHORT);
            }
            }
        });
    }

    public void valide(){
        UserName=(EditText) findViewById(R.id.etName);
        UserPhno=(EditText) findViewById(R.id.etphno);
        UserDob=(EditText) findViewById(R.id.etdate);
        submit=(Button) findViewById(R.id.btsubmit);
        pro=(ImageView) findViewById(R.id.ivProfile);
    }

    private Boolean sendUserData(){
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(UserPhno.getText().toString());
        UserInfo userInfo=new UserInfo(UserName.getText().toString(),UserPhno.getText().toString(),UserDob.getText().toString());
        myRef.setValue(userInfo);
        flag=true;
        return flag;
    }
}
