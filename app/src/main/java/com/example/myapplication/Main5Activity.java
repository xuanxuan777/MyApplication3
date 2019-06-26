package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main5Activity extends AppCompatActivity implements View.OnClickListener {
    private EditText zhanghu1;
    private EditText mi1;
    private EditText id1;
    private Button b1;
    private People use = new People();
    private String d;
    private String e;
    private String f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        /// use = (People) bundle.putSerializable("user",);
        b1 = findViewById(R.id.button);
        zhanghu1 = findViewById(R.id.zhucez);
        mi1 = findViewById(R.id.zhucem);
        id1 = findViewById(R.id.zhuceid);
        id1.setOnClickListener(this);
        zhanghu1.setOnClickListener(this);
        mi1.setOnClickListener(this);
        b1.setOnClickListener(this);
        RadioGroup radiogroup=findViewById(R.id.group);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId)
                {
                    case R.id.nan:
                        d="nan";
                    case R.id.nv:
                        d="nv";
                }
            }
        });
        Switch s=findViewById(R.id.hui);
        s.setOnCheckedChangeListener(new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true)
                {
                    e="会员";
                }
                if(isChecked==false)
                {
                    e="非会员";
                }
            }
        });
        SeekBar seekBar=findViewById(R.id.seek);
        final TextView t=findViewById(R.id.ti);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                t.setText("体重为:"+progress);
                f=progress+"";
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String a = zhanghu1.getText().toString();
                use.setName(a);
                String b = mi1.getText().toString();
                use.setMima(b);
                String c = id1.getText().toString();
                use.setId(c);
                use.setSex(d);
                use.setHuiyuan(e);
                use.setTizhong(f);
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("user", use);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
        }
    }

}

