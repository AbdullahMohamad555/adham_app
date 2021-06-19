package ucac.edu.ps.foodapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class donation2Fragment extends Fragment {

    private static final String ARG_ID = "id";
    private static final String ARG_NAME = "name";

    private int id;
    private String name;

    public donation2Fragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static donation2Fragment newInstance(int id, String name) {
        donation2Fragment fragment = new donation2Fragment();
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
        return inflater.inflate(R.layout.fragment_donation2, container, false);
    }
}