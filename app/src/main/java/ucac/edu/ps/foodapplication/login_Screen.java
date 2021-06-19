package ucac.edu.ps.foodapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_Screen extends AppCompatActivity {
    private static final String TAG = "login_Screen";
    private EditText et_login_email, et_login_password;
    private Button btn_login;
    private TextView tv_forgotPassword, tv_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        et_login_email = findViewById(R.id.et_login_email);
        et_login_password = findViewById(R.id.et_login_password);
        btn_login = findViewById(R.id.btn_loginUser);
        tv_forgotPassword = findViewById(R.id.tv_login_forgotPass);
        tv_arrow = findViewById(R.id.tv_login_arrow);

        tv_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

        tv_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), forgotPassword.class);
                startActivity(intent);
            }
        });
    }

    private void LoginUser() {
        String email = et_login_email.getText().toString();
        String pass = et_login_password.getText().toString();
        if (email.isEmpty() || pass.isEmpty()) {
            Snackbar.make(findViewById(android.R.id.content), "pleas fill in emile or password !", Snackbar.LENGTH_SHORT).show();
            return;
        }
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "Create User With Email Success");
                    Intent intent = new Intent(getApplicationContext(), TabedActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Log.w(TAG, "Auth Filed: ", task.getException());
                    Snackbar.make(findViewById(android.R.id.content), "Auth Filed", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Application")
                .setMessage("Are you sure close Application ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        System.exit(0);
                    }
                }).setNegativeButton("No", null).show();
    }
}