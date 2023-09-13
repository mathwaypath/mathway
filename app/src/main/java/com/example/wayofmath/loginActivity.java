package com.example.wayofmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    EditText username,password;
    Button btnlogin;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin=(Button)  findViewById(R.id.btnsignin1);
        DB=new DBHelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(loginActivity.this,"Please Enter All The Fields",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkerboards = DB.checkusernamepassword(user,pass);
                    if(checkerboards==true){
                        Toast.makeText(loginActivity.this,"Sign In Successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),homeactivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(loginActivity.this,"invalid Credentials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    }
