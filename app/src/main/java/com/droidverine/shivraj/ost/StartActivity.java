package com.droidverine.shivraj.ost;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
   Button bt1,bt2;
    EditText editText,editText1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editText=(EditText)findViewById(R.id.nameedt);
        editText1=(EditText)findViewById(R.id.emailedt);
        bt1=(Button)findViewById(R.id.btn1);
        bt2=(Button)findViewById(R.id.btn2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** EXPLICIT INTENT*/
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("Name",editText.getText().toString());
                intent.putExtra("Email",editText1.getText().toString());
                startActivity(intent);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** IMPLICIT INTENT*/
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT," name :"+editText.getText().toString()+"\n Pass :"+editText1.getText().toString());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });


    }
}
