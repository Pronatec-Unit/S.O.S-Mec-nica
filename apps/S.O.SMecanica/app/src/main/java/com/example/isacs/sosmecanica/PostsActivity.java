package com.example.isacs.sosmecanica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PostsActivity extends AppCompatActivity {

    private static FirebaseDatabase database;
    private DatabaseReference categoriaRef;
    private DatabaseReference categoria;
    private ListView listView;
    private List<Categoria> postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        listView = (ListView) findViewById(R.id.postsList);

        database = Utils.getDatabase();

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String catSelecionada = bundle.getString("txt");

        categoriaRef = database.getReference("categoria");

        categoria = categoriaRef.child(catSelecionada);

        categoria.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                postsList = new ArrayList<Categoria>();

                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                while (iterator.hasNext()) {

                    Categoria value = iterator.next().getValue(Categoria.class);

                    postsList.add(value);
                }

                ArrayAdapter adapter = setupAdapter(postsList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Toast.makeText(PostsActivity.this, "PARECE QUE NÃO HÁ INTERNET! /n Verifique a sua conexão para continuar navegando. /n Atualize a Pagina!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ArrayAdapter setupAdapter(final List<Categoria> postsList) {
        ArrayAdapter adapter = new ArrayAdapter(this
                , android.R.layout.simple_list_item_2
                , android.R.id.text1, postsList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {



                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                TextView text2 = (TextView) view.findViewById(android.R.id.text2);
                text1.setText("R$ "+String.valueOf(postsList.get(position).getPreco()));
                text2.setText("Veiculo: " + postsList.get(position).getVeiculo() + "\nEstabelecimento: " + postsList.get(position).getEstabelecimento() + "\n" + postsList.get(position).getCidade()+ ", rua " + postsList.get(position).getRua()+", " + postsList.get(position).getComplemento()+"\nas "+ postsList.get(position).getDataHora());
                return view;

                //String.valueOf(friendsList.get(position).getTelephoneNumber()) <<-- Add valor tipo inteiro
            }
        };
        return adapter;
    }
}
