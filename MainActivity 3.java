 package com.macair.mad;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText x;
    TextView y;
    Button z;


    TextView tv1;
    Button bt_inc,bt_dec;

    int no1 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tv1 = findViewById(R.id.tv1);
        bt_inc = findViewById(R.id.bt_inc);
        bt_dec = findViewById(R.id.bt_dec);

        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);

        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = x.getText().toString();
                y.setText("Hello " +s1+"!");
            }
        });

        bt_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no1 = no1+1;
                tv1.setText(Integer.toString(no1));

                Toast.makeText(getApplicationContext(), "Value Incremented", Toast.LENGTH_SHORT).show();
            }
        });
        bt_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                no1 = no1-1;
                tv1.setText(Integer.toString(no1));

                Toast.makeText(getApplicationContext(), "Value Decremented", Toast.LENGTH_SHORT).show();
            }
        });
    }
}