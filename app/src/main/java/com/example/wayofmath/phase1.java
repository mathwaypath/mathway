package com.example.wayofmath;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phase1 extends AppCompatActivity {
           //  private Button button;
           //  private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phase1);
             //      context = this;
               //    button=findViewById(R.id.button);
                 //  button.setOnClickListener(new View.OnClickListener() {
                       //@Override
                   //    public void onClick(View view){
                     //      Intent intent=new Intent(context,add.class);
                       //    startActivity(intent);

                       //}
                   //});

    }
    public void addition(View v)
    {
        Intent i = new Intent(this, add.class);
        startActivity(i);
    }
    public void subtraction(View v)
    {
        Intent i = new Intent(this, subtraction.class);
        startActivity(i);
    }

    public void multiplication(View v)
    {
        Intent i = new Intent(this, multipication.class);
        startActivity(i);
    }
    public void division(View v) {
        Intent i = new Intent(this, division.class);
        startActivity(i);
    }

    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are You Sure You Want to Quit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Keep Playing", null)
                .show();
    }


}

