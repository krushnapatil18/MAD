package com.example.lab3;

import android.content.Intent;
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

    EditText n ;
    TextView tv2;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        n = findViewById(R.id.et1);
        tv2 = findViewById(R.id.tv2);
        bt = findViewById(R.id.bt1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float s=0;
                float k = Integer.parseInt(n.getText().toString());
                if (k > 0) {
                    for (float i = 1; i <= k; i++) {
                        s = s + (1 / i);
                    }
                    tv2.setText(Float.toString(s));
                }
                else{
                    tv2.setText("Enter Greater than zero");

                }

                Intent intent1 = new Intent(getApplicationContext(), MainActivity2.class);
                String ss = Float.toString(s);
                intent1.putExtra("abc",ss);
                startActivity(intent1);
            }




        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.bt2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}