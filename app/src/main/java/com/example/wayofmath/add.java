package com.example.wayofmath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class add extends AppCompatActivity {
    private TextView questiontv, questionNumbertv;
    private Button option1btn, option2btn, option3btn, option4btn;
    private ArrayList<quizmodel> quizmodelArrayList;
    Random random;
    int currentscore = 0, questionattempted = 1, currentpos;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

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
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(add.this);
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
        quizmodelArrayList.add(new quizmodel("8 + 6", "10", "12", "14", "16", "14"));
        quizmodelArrayList.add(new quizmodel("4 + 4", "8", "6", "9", "10", "8"));
        quizmodelArrayList.add(new quizmodel("9 + 2", "12", "11", "13", "10", "11"));
        quizmodelArrayList.add(new quizmodel("6 + 5", "10", "11", "12", "13", "11"));
        quizmodelArrayList.add(new quizmodel("1 + 8 ", "10", "11", "9", "12", "9"));
        quizmodelArrayList.add(new quizmodel("3 + 3", "9", "11", "13", "15", "9"));
        quizmodelArrayList.add(new quizmodel("6 + 4", "9", "13", "12", "10", "10"));
        quizmodelArrayList.add(new quizmodel("7 + 5", "11", "13", "14", "12", "12"));
        quizmodelArrayList.add(new quizmodel("8 + 9", "17", "16", "18", "15", "17"));
        quizmodelArrayList.add(new quizmodel("8 + 8", "15", "17", "16", "18", "16"));
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