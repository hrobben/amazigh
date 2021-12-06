package com.example.testfirebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        make_hello_world();
        show_hello_world();
    }

    private void make_hello_world() {
        Date currentTime = Calendar.getInstance().getTime();
        String m = "Firebase-Test: " + currentTime.toString();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue(m);

        Toast.makeText(getApplicationContext(), "Melding: " + m, Toast.LENGTH_SHORT).show();
    }

    private void show_hello_world() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        ValueEventListener mListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue());
                String m = dataSnapshot.getValue().toString();
                Toast.makeText(getApplicationContext(), "Opgeslagen: " + m, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getMessage());
            }
        };
        myRef.addValueEventListener(mListener);
    }

    public void message_refresh(View view) {
        make_hello_world();
        TextView tv1 = (TextView)findViewById(R.id.textView1);
        tv1.setText("Pressed Refresh!");
    }

    public void woorden_lijst(View view) {
        DatabaseReference databaseReference;
        ListView listView;
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter;

        setContentView(R.layout.activity_main);
        databaseReference=FirebaseDatabase.getInstance().getReference("woorden");
        listView=(ListView)findViewById(R.id.listView1);
        arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value=snapshot.getValue(Woorden.class).toString();
                arrayList.add(value);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}