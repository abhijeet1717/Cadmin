package com.codewithabhijeet.cadmin.Faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.codewithabhijeet.cadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

//    FloatingActionButton fab;
//    private RecyclerView cs,it,ece;
//    private LinearLayout csNoData,itNoData,eceNoData;
//    private List<TeacherData> list1,list2,list3;
//    private TeacherAdapter adapter;

//    private DatabaseReference reference,dbRef;

    private FloatingActionButton floatingActionButton;
    private LinearLayout csNoData,itNoData,eceNoData;
    private RecyclerView cs,it,ece;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        floatingActionButton = findViewById(R.id.fab);
        cs  = findViewById(R.id.csDep);
        it = findViewById(R.id.itDep);
        ece = findViewById(R.id.civilDep);
        csNoData = findViewById(R.id.csNoData);
      itNoData = findViewById(R.id.itNoData);
        eceNoData = findViewById(R.id.civilNoData);

//        fab = findViewById(R.id.fab);
//        cs = findViewById(R.id.csDep);
//        it = findViewById(R.id.itDep);
//        ece = findViewById(R.id.civilDep);
//
//        csNoData = findViewById(R.id.csNoData);
//        itNoData = findViewById(R.id.itNoData);
//        eceNoData = findViewById(R.id.civilNoData);
//        reference = FirebaseDatabase.getInstance().getReference();

//        cs();
//        it();
//        ece();
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(UpdateFaculty.this,AddTeacher.class));
//            }
//        });

    }
//    private void cs(){
//        dbRef = reference.child("cs");
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list1 = new ArrayList<>();
//                if(!snapshot.exists()){
//                    csNoData.setVisibility(View.VISIBLE);
//                    cs.setVisibility(View.GONE);
//                }else{
//                    csNoData.setVisibility(View.GONE);
//                    cs.setVisibility(View.VISIBLE);
//                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                        TeacherData data =snapshot.getValue(TeacherData.class);
//                        list1.add(data);
//                    }
//                    cs.setHasFixedSize(true);
//                    cs.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
//                    adapter = new TeacherAdapter(list1,UpdateFaculty.this);
//                    cs.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void it(){
//        dbRef = reference.child("it");
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list2 = new ArrayList<>();
//                if(!snapshot.exists()){
//                    itNoData.setVisibility(View.VISIBLE);
//                    it.setVisibility(View.GONE);
//                }else{
//                    itNoData.setVisibility(View.GONE);
//                    it.setVisibility(View.VISIBLE);
//                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                        TeacherData data =snapshot.getValue(TeacherData.class);
//                        list2.add(data);
//                    }
//                    it.setHasFixedSize(true);
//                    it.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
//                    adapter = new TeacherAdapter(list2,UpdateFaculty.this);
//                    cs.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    private void ece(){
//        dbRef = reference.child("ece");
//        dbRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                list3 = new ArrayList<>();
//                if(!snapshot.exists()){
//                    eceNoData.setVisibility(View.VISIBLE);
//                    ece.setVisibility(View.GONE);
//                }else{
//                    eceNoData.setVisibility(View.GONE);
//                    ece.setVisibility(View.VISIBLE);
//                    for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                        TeacherData data =snapshot.getValue(TeacherData.class);
//                        list3.add(data);
//                    }
//                    ece.setHasFixedSize(true);
//                    ece.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
//                    adapter = new TeacherAdapter(list3,UpdateFaculty.this);
//                    ece.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(UpdateFaculty.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}