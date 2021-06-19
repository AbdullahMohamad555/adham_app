package ucac.edu.ps.foodapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class forgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        EditText et_forget_email = findViewById(R.id.et_forget_email);
        Button btn_forget = findViewById(R.id.btn_forgot);
        FirebaseAuth auth = FirebaseAuth.getInstance();

        btn_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sendEmail = et_forget_email.getText().toString();
                auth.sendPasswordResetEmail(sendEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Snackbar.make(findViewById(android.R.id.content), "Send Email Success", Snackbar.LENGTH_LONG).show();
                            finish();
                        } else {
                            Snackbar.make(findViewById(android.R.id.content), "Invalid Email !", Snackbar.LENGTH_LONG).show();
                            Log.e("Adham=>", task.getException().toString());
                        }
                    }
                });
            }
        });


    }
}