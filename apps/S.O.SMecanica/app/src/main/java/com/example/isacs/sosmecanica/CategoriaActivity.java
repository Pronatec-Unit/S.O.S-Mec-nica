package com.example.isacs.sosmecanica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CategoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
    }

    public void PostsPneu(View view){
        Intent intent = new Intent(this,PostsActivity.class);

        String txt = "pneu";
        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void PostsOleos(View view){
        Intent intent = new Intent(this,PostsActivity.class);

        String txt = "oleos";
        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void PostsMotor(View view){
        Intent intent = new Intent(this,PostsActivity.class);

        String txt = "motor";
        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void PostsComb(View view){
        Intent intent = new Intent(this,PostsActivity.class);

        String txt = "combustiveis";
        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void PostsGuincho(View view){
        Intent intent = new Intent(this,PostsActivity.class);

        String txt = "guincho";
        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    public void PostsItens(View view){
        Intent intent = new Intent(this,PostsActivity.class);

        String txt = "itens de segurança";
        Bundle bundle = new Bundle();

        bundle.putString("txt", txt);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
