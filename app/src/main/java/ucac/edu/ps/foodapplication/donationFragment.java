package ucac.edu.ps.foodapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class donationFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<String> data;

    private static final String ARG_ID = "id";
    private static final String ARG_NAME = "name";

    private int id;
    private String name;

    public donationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static donationFragment newInstance(int id, String name) {
        donationFragment fragment = new donationFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ID, id);
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Data_donation2> images = new ArrayList<>();
        images.add(new Data_donation2(1,R.drawable.student,"كفالة تعليم طالب"));
        images.add(new Data_donation2(2,R.drawable.water,"ساهم في توصيل المياه"));
        images.add(new Data_donation2(3,R.drawable.family,"شارك في اسعاد عائلة"));

        View view= inflater.inflate(R.layout.fragment_donation, container, false);
        recyclerView= view.findViewById(R.id.recycle_view_dona_1);
        adapterRecyclerViewDonation_F adapter = new adapterRecyclerViewDonation_F(getContext(), data, new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int id) {

            }
        });
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}