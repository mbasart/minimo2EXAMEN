package dsa.eetac.upc.edu.exampleminim2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import dsa.eetac.upc.edu.exampleminim2.models.Element;

public class ListFollowersAdapter extends RecyclerView.Adapter<ListFollowersAdapter.ViewHolder> {

    private List<Element> dataset3;
    private Context context;

    public ListFollowersAdapter(Context context) {
        this.context = context;
        this.dataset3 = new ArrayList<>();
    }

    @Override
    public ListFollowersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_follower,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ListFollowersAdapter.ViewHolder holder, int position) {
        Element element = dataset3.get(position);
        holder.loginFollowerTextView.setText(element.getMunicipiNom());
        holder.ineFollowerTextView.setText(element.getIne());
        Picasso.with(context).load(element.getMunicipiEscut()).into(holder.fotoFollowerImageView);
    }

    @Override
    public int getItemCount() {
        return dataset3.size();
    }

    public void addCities(List<Element> listElement){
        dataset3.addAll(listElement);
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private LinearLayout linearLayout;
        private ImageView fotoFollowerImageView;
        private TextView loginFollowerTextView;
        private TextView ineFollowerTextView;

        public ViewHolder(View itemView){
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linearLayout);
            fotoFollowerImageView = itemView.findViewById(R.id.fotoImageView);
            loginFollowerTextView =  itemView.findViewById(R.id.textView_login);
            ineFollowerTextView =  itemView.findViewById(R.id.textView_ine);
        }
    }
}
