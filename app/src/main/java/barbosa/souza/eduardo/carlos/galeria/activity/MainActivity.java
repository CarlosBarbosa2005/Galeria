package barbosa.souza.eduardo.carlos.galeria.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import barbosa.souza.eduardo.carlos.galeria.R;
import barbosa.souza.eduardo.carlos.galeria.adapter.MyAdapter;
import barbosa.souza.eduardo.carlos.galeria.model.MyItem;
import barbosa.souza.eduardo.carlos.galeria.util.Util;

public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST =1;

    MyAdapter myAdapter;
    List<MyItem> itens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fabAddItem = findViewById(R.id.fabAddNewItem);
        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,NewItemActivity.class);
                startActivityForResult(i,NEW_ITEM_REQUEST);

            }
        });
        RecyclerView rvItens = findViewById(R.id.rvitens);

        myAdapter = new MyAdapter(this,itens);
        rvItens.setAdapter(myAdapter);

        rvItens.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvItens.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvItens.getContext(),DividerItemDecoration.VERTICAL);
        rvItens.addItemDecoration(dividerItemDecoration);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == NEW_ITEM_REQUEST){
            if (resultCode == Activity.RESULT_OK){
                MyItem myItem = new MyItem();
                myItem.title = data.getStringExtra("title");
                myItem.description = data.getStringExtra("description");
                Uri selectedPhotoUri = data.getData();

                try {
                    Bitmap photo = Util.getBitmap(MainActivity.this,selectedPhotoUri,100,100);
                        myItem.photo = photo;
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }

                itens.add(myItem);
                myAdapter.notifyItemInserted(itens.size()-1);
            }
        }
    }
}