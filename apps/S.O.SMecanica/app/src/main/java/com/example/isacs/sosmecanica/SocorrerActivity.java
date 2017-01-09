package com.example.isacs.sosmecanica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SocorrerActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference categoriaRef;
    Spinner categorias;
    EditText estabelecimentoEdit;
    EditText veiculoEdit;
    EditText precoEdit;
    EditText cidadeEdit;
    EditText ruaEdit;
    EditText complementoEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socorrer);

        categorias = (Spinner) findViewById(R.id.categorias);
        estabelecimentoEdit = (EditText) findViewById(R.id.estabelecimento);
        veiculoEdit = (EditText) findViewById(R.id.veiculo);
        precoEdit = (EditText) findViewById(R.id.preco);
        cidadeEdit = (EditText) findViewById(R.id.cidade);
        ruaEdit = (EditText) findViewById(R.id.rua);
        complementoEdit = (EditText) findViewById(R.id.complemento);



        database = Utils.getDatabase();
        categoriaRef = database.getReference("categoria");

        //Cria um Adapter com o Arrey de String para inserir no Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.categorias,android.R.layout.simple_spinner_item);

        //Inseri o ArreyAdapter no Spinner
        categorias.setAdapter(adapter);

        //Escuta o Spinner(Select) para executar uma ação quando uma opção for selecionada
        AdapterView.OnItemSelectedListener escolha = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        //Vincula a Escuta ao Spinner
        categorias.setOnItemSelectedListener(escolha);
    }

    public void PrepararAddPost(DatabaseReference databaseReference){

        String estabelecimento = estabelecimentoEdit.getText().toString();
        String veiculo = veiculoEdit.getText().toString();
        double preco = Double.parseDouble(precoEdit.getText().toString());
        String cidade = cidadeEdit.getText().toString();
        String rua = ruaEdit.getText().toString();
        String complemento = complementoEdit.getText().toString();
        String dataHora = Utils.getHoraAtual()+" de "+Utils.getDataAtual();

        String key = databaseReference.push().getKey();
        Categoria categoria = new Categoria(preco,veiculo,estabelecimento,cidade,rua,complemento,dataHora);
        databaseReference.child(key).setValue(categoria);

    }

    public void AddPost(View view){

        String estabelecimento = estabelecimentoEdit.getText().toString();
        String veiculo = veiculoEdit.getText().toString();

        if(estabelecimento == "" && veiculo == ""){

            Toast.makeText(SocorrerActivity.this, "Preencha os campos acima! ", Toast.LENGTH_SHORT).show();

        }else{

            String categoria = categorias.getSelectedItem().toString();

            DatabaseReference categoriaBD = categoriaRef.child(categoria);
            PrepararAddPost(categoriaBD);

            Toast.makeText(SocorrerActivity.this, "Post adicionado com sucesso!", Toast.LENGTH_SHORT).show();

            estabelecimentoEdit.setText("");
            veiculoEdit.setText("");
            precoEdit.setText("");
            cidadeEdit.setText("");
            ruaEdit.setText("");
            complementoEdit.setText("");
        }
    }
}
