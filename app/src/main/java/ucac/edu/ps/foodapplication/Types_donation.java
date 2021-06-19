package ucac.edu.ps.foodapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Types_donation extends AppCompatActivity {
    private ListView lv_type;
    private String[] textList = {"سهم في توصيل المياه", "كفالة أسرة", "كفالة تعليم طالب ", "سهم في علاج شهري"};
    private int[] icons = {
            R.drawable.drinking,
            R.drawable.family,
            R.drawable.proud,
            R.drawable.medicine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_donation);

        lv_type = findViewById(R.id.lv_typeDonation);

        MyListAdapter adapter = new MyListAdapter(getApplicationContext(), R.layout.custom_list, textList, icons);
        lv_type.setAdapter(adapter);
    }
}