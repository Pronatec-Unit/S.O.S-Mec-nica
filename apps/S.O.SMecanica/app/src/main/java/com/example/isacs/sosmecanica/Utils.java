package com.example.isacs.sosmecanica;

import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by isacs on 17/12/2016.
 */

public class Utils {
    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

    public static String getHoraAtual(){
        SimpleDateFormat dateFormat_hora = new SimpleDateFormat("HH:mm:ss");

        Date data = new Date();

        Calendar  cal = Calendar.getInstance();
        cal.setTime(data);
        Date atual = cal.getTime();

        String hora_atual = dateFormat_hora.format(atual);

        return hora_atual;
    }

    public static String getDataAtual(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date data = new Date();

        Calendar  cal = Calendar.getInstance();
        cal.setTime(data);
        Date atual = cal.getTime();

        String data_atual = dateFormat.format(atual);

        return data_atual;
    }

}
