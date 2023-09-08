package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    Button button;
    EditText edi1,edi2,edi3,edi4,ediId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        button = findViewById (R.id.btn1);
      //  ediId = findViewById (R.id.editid);
        edi1 = findViewById (R.id.edi1);
        edi2 = findViewById (R.id.edi2);
        edi3 = findViewById (R.id.edi3);

        myDb = new DatabaseHelper (this);
        myDb.getWritableDatabase ();

        button.setOnClickListener (view ->
        {
            boolean IsInserted = myDb.insertData (edi1.getText ().toString (),edi2.getText ().toString (),edi3.getText ().toString ());

            if (IsInserted==true)
            {
                Toast.makeText (MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show ();
            }
            else 
            {
                Toast.makeText (MainActivity.this, "Data is not inserted", Toast.LENGTH_SHORT).show ();
            }
        });
    }
}