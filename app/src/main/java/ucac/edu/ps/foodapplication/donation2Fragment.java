package ucac.edu.ps.foodapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class donation2Fragment extends Fragment {

    adapterRecyclerViewDonation2_F adapter;
    RecyclerView recyclerView;
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
        ArrayList<Data_donation2> images = new ArrayList<>();
        images.add(new Data_donation2(1,R.drawable.student,"كفالة تعليم طالب"));
        images.add(new Data_donation2(2,R.drawable.water,"ساهم في توصيل المياه"));
        images.add(new Data_donation2(3,R.drawable.family,"شارك في اسعاد عائلة"));
        images.add(new Data_donation2(4,R.drawable.midicine,"ساهم في علاج شهري"));
        images.add(new Data_donation2(5,R.drawable.food,"شارك في اطعام المحتاج"));
        images.add(new Data_donation2(6,R.drawable.hospital,"ساهم لمساعدة المريض"));
        images.add(new Data_donation2(7,R.drawable.with_special_needs,"ساعد اصحاب الاولويات الخاصة"));

        View v= inflater.inflate(R.layout.fragment_donation2, container, false);
        recyclerView = v.findViewById(R.id.recycle_view_dona_2);
        adapter = new adapterRecyclerViewDonation2_F(getContext(), images, new OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(int id) {
                switch (id){
                    case 1:
                        Intent intent = new Intent(getContext(),Student.class);
                        startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(getContext(),Water.class);
                        startActivity(intent1);
                        break;
                    case 3:
                        Intent intent2 =new Intent(getContext(),dona_family.class);
                        startActivity(intent2);
                        break;
                    case 4:
                        Intent intent3 =new Intent(getContext(),dona_Midicine.class);
                        startActivity(intent3);
                        break;
                    case 5:
                        Intent intent4 =new Intent(getContext(),donation_Food.class);
                        startActivity(intent4);
                        break;
                    case 6:
                        Intent intent5 =new Intent(getContext(),dona_Hospital.class);
                        startActivity(intent5);
                        break;
                    case 7:
                        Intent intent6 =new Intent(getContext(),dona_with_special_needs.class);
                        startActivity(intent6);
                        break;


                }
            }
        });



        recyclerView.setAdapter(adapter);
        RecyclerView.LayoutManager lm = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        return v;
    }
}