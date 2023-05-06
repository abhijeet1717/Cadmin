package com.codewithabhijeet.cadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1 = (EditText) findViewById(R.id.email);
        e2 = (EditText) findViewById(R.id.password);
        b1 = (Button) findViewById(R.id.btn);
        t1 = findViewById(R.id.textView);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(LoginActivity.this, "Pls mark all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data = openOrCreateDatabase("databasemera",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists syndicate (name varchar,email varchar,password varchar)");
                    String s3="select * from syndicate where email='"+s1+"' and password='"+s2+"'";
                    Cursor c1=data.rawQuery(s3,null);
                    if(c1.getCount()>0){
                        Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(LoginActivity.this,MainActivity.class);
                        j.putExtra("result",s1);
                        startActivity(j);
                        finish();
                    }else{
                        Toast.makeText(LoginActivity.this, "invalid data pls try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}