package com.example.uiwidgettest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.transition.MaterialElevationScale;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    Boolean flag=true;
    private static final String TAG = "MainActivity";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button) findViewById(R.id.button);
        editText=(EditText) findViewById(R.id.edit_view);
        imageView=(ImageView)findViewById(R.id.image_view);
        progressBar1=(ProgressBar) findViewById(R.id.progress_bar1);
        progressBar2=(ProgressBar) findViewById(R.id.progress_bar2);
        Log.d(TAG, "onCreate: imageView.getId()");
        button.setOnClickListener(this);
    }


    @SuppressLint("ResourceType")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.button:
                // EditText
                String s = editText.getText().toString();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();

                // ImageView
                if (flag){
                    imageView.setImageResource(R.drawable.image2);
                    flag=false;
                }else {
                    imageView.setImageResource(R.drawable.image1);
                    flag=true;
                }

                // ProgressBar 样式1
                if (progressBar1.getVisibility()==view.GONE){
                    progressBar1.setVisibility(view.VISIBLE);
                }else {
                    progressBar1.setVisibility(view.GONE);
                }
                // ProgressBar 样式1
                int progress = progressBar2.getProgress();
                progress=progress+10;
                progressBar2.setProgress(progress);

                // AlertDialog
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a dialog");
                dialog.setMessage("one more thing");
                dialog.setCancelable(false);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
            default:
                break;
        }

    }
}