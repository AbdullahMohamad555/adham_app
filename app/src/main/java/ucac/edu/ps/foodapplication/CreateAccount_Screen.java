package ucac.edu.ps.foodapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateAccount_Screen extends AppCompatActivity {

    private static final String TAG = "CreateAccount_Screen";

    private EditText et_create_fullName, et_create_phone, et_create_email, et_create_address, et_create_pass;
    private Button btn_create_register;
    private TextView tv_arrow;
    FirebaseAuth auth;
    FirebaseAuth.AuthStateListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_screen);

        et_create_fullName = findViewById(R.id.et_createAccount_fullName);
        et_create_phone = findViewById(R.id.et_createAccount_phone);
        et_create_email = findViewById(R.id.et_createAccount_email);
        et_create_address = findViewById(R.id.et_createAccount_address);
        et_create_pass = findViewById(R.id.et_createAccount_password);
        btn_create_register = findViewById(R.id.btn_createAccount_register);
        tv_arrow = findViewById(R.id.tv_create_arrow);

        auth = FirebaseAuth.getInstance();

        tv_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_create_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUpUser();
            }
        });
    }

    private void SignUpUser() {
        String name = et_create_fullName.getText().toString();
        String phone = et_create_phone.getText().toString();
        String email = et_create_email.getText().toString();
        String address = et_create_address.getText().toString();
        String pass = et_create_pass.getText().toString();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || address.isEmpty() || pass.isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content), "Pleas Fill", Snackbar.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Create User With Email Success");
                    Intent intent = new Intent(getApplicationContext(), TabedActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.w(TAG, "Invalid Email : ", task.getException());
                    Toast.makeText(CreateAccount_Screen.this, "Auth Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}