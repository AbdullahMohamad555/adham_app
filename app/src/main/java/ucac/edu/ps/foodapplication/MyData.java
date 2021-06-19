package ucac.edu.ps.foodapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MyData {
     ImageView imageView;
     TextView text;

    MyData(View v) {
        imageView = v.findViewById(R.id.custom_iv);
        text = v.findViewById(R.id.custom_tv);
    }
}
