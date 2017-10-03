package com.droidverine.shivraj.ost;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by DELL on 03-10-2017.
 */

public class SecondActivity extends AppCompatActivity {
    TextView textView1,textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        String pass=intent.getStringExtra("Email");
        textView1=(TextView)findViewById(R.id.nametxt);
        textView2=(TextView)findViewById(R.id.emailtxt);
        textView1.setText("Name:"+name);
        textView2.setText("Email:"+pass);


    }
}
