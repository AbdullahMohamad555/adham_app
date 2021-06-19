package ucac.edu.ps.foodapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class MyListAdapter extends ArrayAdapter<String> {

    Context context;
    String[] text;
    int[] icons;

    public MyListAdapter(@NonNull Context context, int resource, String[] text, int[] icons) {
        super(context, R.layout.custom_list, R.id.custom_tv, text);
        this.context = context;
        this.text = text;
        this.icons = icons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        MyData data = null;

        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.custom_list, null, false);
            data = new MyData(v);
            v.setTag(data);
        } else {
            data = (MyData) v.getTag();
        }
        data.imageView.setImageResource(icons[position]);
        data.text.setText(text[position]);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        getContext().startActivity(new Intent(getContext(), WhoWe_Activity.class));
                        break;
                    case 1:
                        getContext().startActivity(new Intent(getContext(), Types_donation.class));
                }
            }
        });
        return v;
    }
}
