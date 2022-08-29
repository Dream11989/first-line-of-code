package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.InetSocketAddress;
import java.util.stream.Stream;

public class FirstActivity extends AppCompatActivity {

    // 用来接收上一个活动销毁后返回来的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String data_return = data.getStringExtra("data_return");
                    Log.d("FirstActivity", data_return);
                }
                break;
            default:
        }
    }

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
        setContentView(R.layout.first_layout);
        Button buttonId = (Button)findViewById(R.id.button1);
        buttonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
/*                Toast.makeText(FirstActivity.this,"you clicked butoon1",Toast.LENGTH_LONG).show();
                finish();*/

//                Intent intent = new Intent(FirstActivity.this, secondActivity.class);\

/*
                Intent intent = new Intent("com.example.myapplication2.ACTION_START");
                intent.addCategory("com.example.myapplication2.MY_CATEGORY1");
*/

/*

//   通过intent 隐式交互 切换到百度浏览器
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
//              intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
*/

/*
//   通过intent 隐式交互 切换到打电话页面
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"))    ;
                startActivity(intent2);*/

/*                // 向下一个活动传递数据
                String data="hello SecondActivity";
                Intent intent3 = new Intent(FirstActivity.this, secondActivity.class);
                intent3.putExtra("extra_data",data);
                startActivity(intent3);*/

                //返回数据给上一个活动，
                Intent intent4 = new Intent(FirstActivity.this, secondActivity.class);
                startActivityForResult(intent4,1);

            }

        });


    }
}