package ucac.edu.ps.foodapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MoreFragment extends Fragment {

    private static final String ARG_ID = "id";
    private static final String ARG_NAME = "name";
    private int id;
    private String name;
    // My Variable
    private ListView lv;

    private String[] textList = {"من نحن", "أنواع التبرع", "إتصل بنا", "الأخبار", "خيرك دايم", "أنشطة تنوعية"};
    private int[] iconsList = {
            R.drawable.who,
            R.drawable.donationess,
            R.drawable.phones,
            R.drawable.news,
            R.drawable.loves,
            R.drawable.preview
    };

    public MoreFragment() {
        // Required empty public constructor
    }

    public static MoreFragment newInstance(int id, String name) {
        MoreFragment fragment = new MoreFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_ID);
            name = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv = view.findViewById(R.id.list_fragment);

        MyListAdapter adapter = new MyListAdapter(getActivity(), R.layout.custom_list, textList, iconsList);
        lv.setAdapter(adapter);
    }
}