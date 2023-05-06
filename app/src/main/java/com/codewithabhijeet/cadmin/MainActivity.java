package com.codewithabhijeet.cadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codewithabhijeet.cadmin.Faculty.UpdateFaculty;
import com.codewithabhijeet.cadmin.Notice.DeleteNotice;
import com.codewithabhijeet.cadmin.Notice.UploadNotice;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MaterialCardView uploadNotice,addGallery,addEBook, addFaculty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        uploadNotice =  findViewById(R.id.addNotice);
        addGallery =  findViewById(R.id.addGallery);
        addEBook = findViewById(R.id.addEbook);
        addFaculty = findViewById(R.id.addFaculty);

        uploadNotice.setOnClickListener(this);
        addGallery.setOnClickListener(this);
        addEBook.setOnClickListener(this);
        addFaculty.setOnClickListener(this);


    }
           @Override
            public void onClick(View view) {
                Intent i;
                switch (view.getId()) {
                    case R.id.addNotice:
                        i = new Intent(MainActivity.this, UploadNotice.class);
                        startActivity(i);
                        break;
                    case R.id.addGallery:
                        i = new Intent(MainActivity.this, UploadImage.class);
                        startActivity(i);
                        break;
                    case R.id.addEbook:
                        i = new Intent(MainActivity.this, UploadPdfActivity.class);
                        startActivity(i);
                        break;
                    case R.id.addFaculty:
                        i = new Intent(MainActivity.this, UpdateFaculty.class);
                        startActivity(i);
                        break;
                    case R.id.deleteNotice:
                        i = new Intent(MainActivity.this, DeleteNotice.class);
                        startActivity(i);
                        break;
                }

      }
}