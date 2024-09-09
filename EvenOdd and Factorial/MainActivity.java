package com.example.lab2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num;
    TextView sol;
    Button fact;
    Button even;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

       num = findViewById(R.id.editTextText);
       sol = findViewById(R.id.textView);
       fact = findViewById(R.id.fact);
       even = findViewById(R.id.eo);

       fact.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int num1 = Integer.parseInt(num.getText().toString());
               int fact=1;
               for (int i = 1; i <= num1; i++) {
                   fact *= i;
               }
               sol.setText(Integer.toString(fact));
           }
       });

       even.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int num1 = Integer.parseInt((num.getText().toString()));
               if(num1%2==0){
                   sol.setText("Even");
               }
               else{
                   sol.setText("Odd");
               }
           }
       });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
               Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
               v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
               return insets;
           });
       }
    }