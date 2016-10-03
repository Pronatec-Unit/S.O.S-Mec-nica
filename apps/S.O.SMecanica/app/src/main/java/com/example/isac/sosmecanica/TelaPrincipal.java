package com.example.isac.sosmecanica;

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
        setContentView(R.layout.mappneus);
    }
    public void chamarOleos(View v){
        setContentView(R.layout.mapoleos);
    }
    public void chamarMotor(View v){
        setContentView(R.layout.mapmotor);
    }
    public void chamarComb(View v){
        setContentView(R.layout.mapcomb);
    }
    public void chamarGhincho(View v){
        setContentView(R.layout.mapguincho);
    }
    public void chamarItens(View v){
        setContentView(R.layout.mapitens);
    }

    public void sair(View v){
        finish();
    }
}
