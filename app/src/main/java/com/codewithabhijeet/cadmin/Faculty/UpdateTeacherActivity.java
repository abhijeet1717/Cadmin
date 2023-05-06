package com.codewithabhijeet.cadmin.Faculty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.codewithabhijeet.cadmin.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;

public class UpdateTeacherActivity extends AppCompatActivity {

     private ImageView updateImageView;
     private EditText updateTeacherName,updateTeacherEmail,updateTeacherPost;
     private Button updateTeacherBtn,deleteTeacherBtn;

     private String name,email,image,post;
     private String downloadUrl,category,uniqueKey;
    private Bitmap bitmap=null;
    private final int Req=1;
    private DatabaseReference reference;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher);

        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        post = getIntent().getStringExtra("post");
        image = getIntent().getStringExtra("image");

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        storageReference = FirebaseStorage.getInstance().getReference();

        uniqueKey = getIntent().getStringExtra("key");
        category =getIntent().getStringExtra("category");;

        updateImageView = findViewById(R.id.updateTeacherImage);
        updateTeacherName = findViewById(R.id.updateTeacherName);
        updateTeacherEmail = findViewById(R.id.updateTeacherEmail);
        updateTeacherPost = findViewById(R.id.updateTeacherPost);
        updateTeacherBtn = findViewById(R.id.updateTeacherBtn);
        deleteTeacherBtn = findViewById(R.id.deleteTeacherBtn);

        try {
            Picasso.get().load(image).into(updateImageView);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        updateTeacherEmail.setText(email);
        updateTeacherName.setText(name);
        updateTeacherPost.setText(post);
        
        updateImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        updateTeacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = updateTeacherName.getText().toString();
                email = updateTeacherEmail.getText().toString();
                post = updateTeacherPost.getText().toString();
                checkValidation();
            }
        });
        deleteTeacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
            }
        });
    }
    private void deleteData(){
        reference.child(category).child(uniqueKey).removeValue();

    }
    private void checkValidation(){
        if(name.isEmpty()){
            updateTeacherName.setError("Blank");
            updateTeacherName.requestFocus();
        }else if(email.isEmpty()){
            updateTeacherEmail.setError("Blank");
            updateTeacherEmail.requestFocus();
        }else if(post.isEmpty()){
            updateTeacherPost.setError("Blank");
            updateTeacherPost.requestFocus();
        } else if (bitmap == null) {
            updateData(image);
        }else {
            uploadImage();
        }
    }


    private void updateData(String s){
        HashMap hs = new HashMap();
        hs.put("name",name);
        hs.put("email",email);
        hs.put("post",post);
        hs.put("image",s);


        reference.child(category).child(uniqueKey).updateChildren(hs).addOnSuccessListener(new OnSuccessListener(){
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(UpdateTeacherActivity.this, "Updated", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateTeacherActivity.this,UpdateFaculty.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
    private void uploadImage(){

    }

        private void openGallery() {
            Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(pickImage,Req);
        }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == Req && resultCode == RESULT_OK) {
                Uri uri = data.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                updateImageView.setImageBitmap(bitmap);
            }
        }
}