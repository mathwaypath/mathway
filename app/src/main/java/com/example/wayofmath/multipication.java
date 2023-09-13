package com.example.wayofmath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class multipication extends AppCompatActivity {

    private TextView questiontv, questionNumbertv;
    private Button option1btn, option2btn, option3btn, option4btn;
    private ArrayList<quizmodel> quizmodelArrayList;
    Random random;
    int currentscore = 0, questionattempted = 1, currentpos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipication);

        questiontv = findViewById(R.id.idtvquestion);
        questionNumbertv = findViewById(R.id.idtvquestionattempted);
        option1btn = findViewById(R.id.idbtnoption1);
        option2btn = findViewById(R.id.idbtnoption2);
        option3btn = findViewById(R.id.idbtnoption3);
        option4btn = findViewById(R.id.idbtnoption4);
        quizmodelArrayList = new ArrayList<>();
        random = new Random();
        getquizquestion(quizmodelArrayList);
        currentpos = random.nextInt(quizmodelArrayList.size());
        setDataToViews(currentpos);
        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option1btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionattempted++;
                currentpos = random.nextInt(quizmodelArrayList.size());
                setDataToViews(currentpos);

            }
        });

        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option2btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionattempted++;
                currentpos = random.nextInt(quizmodelArrayList.size());
                setDataToViews(currentpos);

            }
        });
        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionattempted++;
                currentpos = random.nextInt(quizmodelArrayList.size());
                setDataToViews(currentpos);

            }
        });
        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodelArrayList.get(currentpos).getAnswer().trim().toLowerCase().equals(option4btn.getText().toString().trim().toLowerCase())) {
                    currentscore++;
                }
                questionattempted++;
                currentpos = random.nextInt(quizmodelArrayList.size());
                setDataToViews(currentpos);

            }
        });
    }
    private void showBottomSheet()
    {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(multipication.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idrlscore));
        TextView scoretv = bottomSheetView.findViewById(R.id.idtvscore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idbtnRestart);
        scoretv.setText("Your Score is \n"+currentscore +"\10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentpos = random.nextInt(quizmodelArrayList.size());
                setDataToViews(currentpos);
                questionattempted = 1;
                currentscore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews(int currentpos) {
        questionNumbertv.setText("Questions Attempted:" + questionattempted + "/10");
        if (questionattempted == 10) {
            showBottomSheet();
        } else {
            questiontv.setText(quizmodelArrayList.get(currentpos).getQuestion());
            option1btn.setText(quizmodelArrayList.get(currentpos).getOption1());
            option2btn.setText(quizmodelArrayList.get(currentpos).getOption2());
            option3btn.setText(quizmodelArrayList.get(currentpos).getOption3());
            option4btn.setText(quizmodelArrayList.get(currentpos).getOption4());
        }
    }

    private void getquizquestion (ArrayList < quizmodel > quizmodelArrayList) {
        quizmodelArrayList.add(new quizmodel("8 * 7", "56", "64", "49", "54", "56"));
        quizmodelArrayList.add(new quizmodel("9 * 6", "63", "72", "54", "45", "54"));
        quizmodelArrayList.add(new quizmodel("5 * 8", "35", "40", "45", "50", "40"));
        quizmodelArrayList.add(new quizmodel("6 * 4", "34", "30", "20", "24", "24"));
        quizmodelArrayList.add(new quizmodel("4 * 8 ", "24", "16", "32", "30", "32"));
        quizmodelArrayList.add(new quizmodel("2 * 9", "18", "16", "20", "22", "18"));
        quizmodelArrayList.add(new quizmodel("3 * 10", "03", "15", "20", "30", "30"));
        quizmodelArrayList.add(new quizmodel("1 * 7", "01", "07", "70", "10", "07"));
        quizmodelArrayList.add(new quizmodel("7 * 6", "42", "49", "36", "56", "42"));
        quizmodelArrayList.add(new quizmodel("10 * 10", "10", "1000", "110", "100", "100"));
    }



     // public void level(View v)
     //{
      //  Intent i = new Intent(this, division.class);
        //startActivity(i);
     //}


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

