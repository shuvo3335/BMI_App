package com.example.roomdb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi);

        EditText weight = findViewById(R.id.edt_weight);
        EditText height_ft = findViewById(R.id.edt_height_ft);
        EditText height_in = findViewById(R.id.edt_height_inch);
        Button bmi_calculate = findViewById(R.id.btn_calculate);
        LinearLayout layout = findViewById(R.id.main);
        TextView result = findViewById(R.id.tv_result);


        bmi_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight_value = Integer.parseInt( weight.getText().toString());
                int height_ft_value = Integer.parseInt(height_ft.getText().toString());
                int height_in_value = Integer.parseInt(height_in.getText().toString());

                int total_height = height_ft_value * 12 + height_in_value;
                double final_height = total_height * 0.0254;
                double bmi = weight_value / (final_height * final_height);
//                result.setText(String.valueOf(bmi));

                if (bmi < 18.5){
                    layout.setBackgroundColor(getResources().getColor(R.color.yellow));
                    result.setText("Underweight");
                }
                else if (bmi < 25){
                    result.setText("Normal");
                    layout.setBackgroundColor(getResources().getColor(R.color.green));

                }
                else if (bmi < 30){
                    result.setText("Overweight");
                    layout.setBackgroundColor(getResources().getColor(R.color.red));

                }
                weight.setText("");
                height_ft.setText("");
                height_in.setText("");
            }
        });

    }
}