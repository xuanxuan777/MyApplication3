package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity{
    private EditText zhanghu1;
    private EditText mi1;
    private EditText id1;
    private EditText sexxx;
    private EditText huiyuan;
    private EditText tizhong;
    People use;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent=getIntent();
        Bundle bundle = intent.getExtras();
        use = (People) bundle.getSerializable("user");
        zhanghu1 = findViewById(R.id.zhuang);
        mi1=findViewById(R.id.mi);
        id1=findViewById(R.id.iphone);
        sexxx=findViewById(R.id.sexx);
        huiyuan=findViewById(R.id.huiy);
        tizhong=findViewById(R.id.tiz);
        sexxx.setText(use.getSex());
        huiyuan.setText(use.getHuiyuan());
        tizhong.setText("体重为:"+use.getTizhong());
        zhanghu1.setText(use.getName());
        mi1.setText(use.getMima());
        id1.setText(use.getId());

    }
}
