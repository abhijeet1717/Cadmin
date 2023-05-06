package com.codewithabhijeet.cadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    ImageView iv;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.email);
        e3=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.btn);
        iv = findViewById(R.id.back);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(RegisterActivity.this, "Pls mark all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data =openOrCreateDatabase("databasemera",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists syndicate (name varchar,email varchar,password varchar) ");
                    String s4="select * from syndicate where email='"+s2+"' and name='"+s1+"'";
                    Cursor c1=data.rawQuery(s4,null);
                    if(c1.getCount()>0){
                        Toast.makeText(RegisterActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        data.execSQL("insert into syndicate values ('"+s1+"' , '"+s2+"' , '"+s3+"')");
                        Toast.makeText(RegisterActivity.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}