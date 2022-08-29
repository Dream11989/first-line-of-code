package com.example.myapplication2;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView text_view;
    private EditText text_edit;
    private Editable text_data;  // Used to store the text data in text_edit
    private int font_size = 20; // Font size

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_view = findViewById(R.id.textView1);  // obtain the text_view by ID
        text_edit = findViewById(R.id.editText1);  // obtain the text_edit by ID
//        Log.d(TAG, "onCreate: exeucte");

    }

    ///////////////////////////////////////
// function for "+" button
///////////////////////////////////////
    public void bigger(View v){     //
        text_view.setTextSize(++font_size);          // enlarge size
    }

    ///////////////////////////////////////
// function for "-" button
///////////////////////////////////////
    public void smaller(View v){     // function for "-" button
        text_view.setTextSize(--font_size);       // reduce size
    }

    ///////////////////////////////////////
// function for "ENTER" button
///////////////////////////////////////
    public void text_input(View v){     // function for "Enter" button
        text_data = text_edit.getText(); // obtain text from text_edit
        text_view.setText(text_data.toString());   // display text
    }

}