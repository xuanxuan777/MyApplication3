package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView image1;
    private Button button1; //登录
    static int a=0;         //未注册
    private EditText e1=null;//未写入账号
    private EditText e2=null;//未写入密码
    private Button b1;       //用户注册
    People people=new People();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image1= (ImageView) findViewById(R.id.tupian1);
        button1=findViewById(R.id.denglu);
        e1=findViewById(R.id.zhanghao);
        e2=findViewById(R.id.mima);
        b1=findViewById(R.id.zhuce);
        button1.setOnClickListener(this);
        image1.setOnClickListener(this);
        e1.setOnClickListener(this);
        e2.setOnClickListener(this);
        b1.setOnClickListener(this);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {//匿名类
//                if(a==0)
//                    Toast.makeText(MainActivity.this,"请注册用户",Toast.LENGTH_SHORT).show();
//                if(e1==null&&e2==null&&a!=0)
//                    Toast.makeText(MainActivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();
//                if(e1==null&&e2!=null&&a!=0)
//                    Toast.makeText(MainActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
//                if(e1!=null&&e2==null&&a!=0)
//                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK) {
                    people=(People) data.getSerializableExtra("user");
                    a++;
                    Toast.makeText(MainActivity.this,people.getId()+people.getMima()+people.getName(),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tupian1:
                image1.setImageResource(R.drawable.bbb);
                break;
                default:
                break;
            case R.id.zhuce:
                Intent intent=new Intent(MainActivity.this,Main5Activity.class);
                People user=new People();
                Bundle bundle=new Bundle();
                bundle.putSerializable("user", user);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);
                break;
            case R.id.denglu:
                e1.getText();
                e2.getText();
                if(a==0) {
                    Toast.makeText(MainActivity.this, "请注册用户", Toast.LENGTH_SHORT).show();
                }
                if(e1==null&&e2==null&&a!=0)
                    Toast.makeText(MainActivity.this,"请输入账号密码",Toast.LENGTH_SHORT).show();
                if(e1==null&&e2!=null&&a!=0)
                    Toast.makeText(MainActivity.this,"请输入账号",Toast.LENGTH_SHORT).show();
                if(e1!=null&&e2==null&&a!=0)
                    Toast.makeText(MainActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                String b=e1.getText().toString();//账户
                String c=e2.getText().toString();//密码
                if(b.equals(people.getName())&&c.equals(people.getMima())&&a!=0) {
                    intent=new Intent(MainActivity.this,Main3Activity.class);
                    Bundle bundle2=new Bundle();
                    bundle2.putSerializable("user", people);
                    intent.putExtras(bundle2);
                    startActivity(intent);
                }
        }
    }
}
