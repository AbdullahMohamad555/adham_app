package ucac.edu.ps.foodapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterRecyclerViewDonation2_F extends RecyclerView.Adapter<adapterRecyclerViewDonation2_F.PersonViewHolder> {

    Context context;
    ArrayList<Data_donation2> data;
    OnRecyclerViewItemClickListener listener;

    int id;

    public adapterRecyclerViewDonation2_F(Context context, ArrayList data ,OnRecyclerViewItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;

    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custum_rv_donation2,parent,false);
        PersonViewHolder viewHolder = new PersonViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Data_donation2 d = data.get(position);
        holder.imageView.setImageResource(d.getImage());
        holder.textView.setText(d.getName());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;



        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.custom_dona2_iv);
            textView = itemView.findViewById(R.id.custom_dona2_tv);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(id);
                }
            });

        }
    }

}

