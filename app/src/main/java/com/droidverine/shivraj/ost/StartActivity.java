package com.droidverine.shivraj.ost;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity {
    Button btnExplicit, btnImplicit, startactforresult;
    EditText editText, editText1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME};
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                String number = cursor.getString(column);
                editText.setText(number);
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        editText = (EditText) findViewById(R.id.nameedt);
        editText1 = (EditText) findViewById(R.id.emailedt);
        btnExplicit = (Button) findViewById(R.id.btnexplicit);
        btnImplicit = (Button) findViewById(R.id.btnimplicit);
        startactforresult = (Button) findViewById(R.id.btnstartactforresult);

        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** EXPLICIT INTENT*/
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("Name", editText.getText().toString());
                intent.putExtra("Email", editText1.getText().toString());
                startActivity(intent);
            }
        });
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /** IMPLICIT INTENT*/
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, " name :" + editText.getText().toString() + "\n Pass :" + editText1.getText().toString());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });
        startactforresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
                startActivityForResult(intent, 1);
            }
        });


    }
}
