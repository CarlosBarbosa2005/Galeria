package barbosa.souza.eduardo.carlos.galeria.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import barbosa.souza.eduardo.carlos.galeria.R;
import barbosa.souza.eduardo.carlos.galeria.activity.MainActivity;
import barbosa.souza.eduardo.carlos.galeria.model.MyItem;

public class MyAdapter extends RecyclerView.Adapter{
    MainActivity mainActivity;
    List<MyItem> itens;
        public MyAdapter(MainActivity mainActivity, List<MyItem> itens){
            this.mainActivity = mainActivity;
            this.itens = itens;
        }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.item_list,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            MyItem myItem = itens.get(position);
            View v = holder.itemView;

            ImageView imvfoto = v.findViewById(R.id.imvPhoto);
            imvfoto.setImageURI(myItem.photo);

            TextView tvTitle = v.findViewById(R.id.tvTitle);
            tvTitle.setText(myItem.title);

            TextView tvdesc = v.findViewById(R.id.tvDesc);
            tvdesc.setText(myItem.description);

    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
