package ucac.edu.ps.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Donation extends AppCompatActivity {

    EditText et_firstName , lastName , phone , email ;
    RadioButton rb_zakah , rb_sadaka, rb_outGaza , rb_insideGaza ;
    Button btn_online ,btn_atHome , btn_following;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
    }
}