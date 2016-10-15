package com.example.isac.sosmecanica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telaprincipal);
    }

    public void chamarPneu(View v){
        Intent tela = new Intent(TelaPrincipal.this,MapPneu.class);
        startActivity(tela);
    }
    public void chamarOleos(View v){
        Intent tela = new Intent(TelaPrincipal.this,MapOleos.class);
        startActivity(tela);
    }
    public void chamarMotor(View v){
        Intent tela = new Intent(TelaPrincipal.this,MapMotor.class);
        startActivity(tela);
    }
    public void chamarComb(View v){
        Intent tela = new Intent(TelaPrincipal.this,MapComb.class);
        startActivity(tela);
    }
    public void chamarGhincho(View v){
        Intent tela = new Intent(TelaPrincipal.this,MapGuin.class);
        startActivity(tela);
    }
    public void chamarItens(View v){
        Intent tela = new Intent(TelaPrincipal.this,MapItens.class);
        startActivity(tela);
    }

    public void sair(View v){
        finish();
    }
}
