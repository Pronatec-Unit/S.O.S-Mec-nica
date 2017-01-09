package com.example.isacs.sosmecanica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GritarActivity extends AppCompatActivity {

    private static FirebaseDatabase database;
    private DatabaseReference sosRef;
    EditText nomeEdit;
    EditText itemEdit;
    EditText statusEdit;
    EditText numeroEdit;
    EditText emailEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gritar);

        nomeEdit = (EditText)findViewById(R.id.nome);
        itemEdit = (EditText)findViewById(R.id.items);
        statusEdit = (EditText)findViewById(R.id.status);
        numeroEdit = (EditText)findViewById(R.id.numero);
        emailEdit = (EditText)findViewById(R.id.email);

        database = Utils.getDatabase();
        sosRef = database.getReference("sos");

        sosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        sosRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(GritarActivity.this, "Error: "+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void PrepararAddSOS(DatabaseReference databaseReference){

        String numero = numeroEdit.getText().toString();
        String email = emailEdit.getText().toString();

        String nome = nomeEdit.getText().toString();
        String item = itemEdit.getText().toString();
        String status = statusEdit.getText().toString();
        String contato = numero+" | "+email;
        String dataHora = Utils.getHoraAtual()+" de "+Utils.getDataAtual();

        String key = databaseReference.push().getKey();
        SOS sos = new SOS(nome,item,status,contato,dataHora);
        databaseReference.child(key).setValue(sos);
    }

    public void AddSOS(View view){

        String nome = nomeEdit.getText().toString();
        String item = itemEdit.getText().toString();
        String status = statusEdit.getText().toString();

        if(nome == "" && item == "" && status == ""){

            Toast.makeText(GritarActivity.this, "Preencha os campos acima! ", Toast.LENGTH_SHORT).show();

        }else{

            PrepararAddSOS(sosRef);

            Toast.makeText(GritarActivity.this, "Item adicionado com sucesso!", Toast.LENGTH_SHORT).show();

            numeroEdit.setText("");
            emailEdit.setText("");
            nomeEdit.setText("");
            itemEdit.setText("");
            statusEdit.setText("");
        }
    }
}
