package ucac.edu.ps.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Show_donation extends AppCompatActivity {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_donation);

        editText = findViewById(R.id.show_donation_et);
        button = findViewById(R.id.show_donation_btn);

        Intent intent = getIntent();
        int i = intent.getIntExtra("value",1);

        editText.setText(i);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // حننتقل عشاشة Donation
            }
        });
    }
}