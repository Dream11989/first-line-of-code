package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you click add",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you click remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return  true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

/*        //  接受上一个活动传来的信息
        Intent intent = getIntent();
        String extra_data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity",extra_data);*/

        //  返回信息给上一个活动 firstActivity
        Intent intent1 = new Intent();
        intent1.putExtra("data_return","hello firstactivity");
        setResult(RESULT_OK,intent1);
        finish();
    }
}