package com.example.eloize.mediaunit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText uniNota1 = (EditText) findViewById(R.id.uniNota1);
        final EditText uniNota2 = (EditText) findViewById(R.id.uniNota2);
        final EditText media = (EditText) findViewById(R.id.media);

        final TextView status = (TextView) findViewById(R.id.status);

        Button limpar = (Button) findViewById(R.id.limpar);
        Button calcular = (Button) findViewById(R.id.calcular);

        limpar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                uniNota1.setText("");
                uniNota2.setText("");
                media.setText("");
                status.setText("STATUS");
            }
        });

        calcular.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (uniNota1.getText().equals("") || uniNota2.getText().equals("")){
                    status.setText("Preencha todos os campos!");
                }else{
                    double m1 = Double.parseDouble(uniNota1.getText().toString());
                    double m2 = Double.parseDouble(uniNota2.getText().toString());
                    double m = ((m1*4)+(m2*6))/10;
                    media.setText(Double.toString(m));
                    if(m < 4){
                        status.setText("ALUNO REPROVADO");
                    }else if(m >=4 && m<=5.9){
                        status.setText("ALUNO NA PROVA FINAL");
                    }else if(m >= 6){
                        status.setText("ALUNO APROVADO");
                    }
                }

            }
        });

    }
}
