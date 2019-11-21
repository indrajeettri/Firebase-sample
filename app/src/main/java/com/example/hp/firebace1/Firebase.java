package com.example.hp.firebace1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase extends AppCompatActivity {

    EditText editText,editText2;
    Button button;
    DatabaseReference root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        editText=findViewById(R.id.edit1);
        editText2=findViewById(R.id.edit2);
        button=findViewById(R.id.save1);
        root= FirebaseDatabase.getInstance().getReference();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Firebase.this,"hello",Toast.LENGTH_SHORT).show();
                String name=editText.getText().toString();
                int i=Integer.parseInt(editText2.getText().toString());
                Student student=new Student(name,i);


                root.child("Name").child("Student").setValue(student).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Firebase.this,"success",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Firebase.this,"unsuccess",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

}
