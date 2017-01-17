package com.alexapplication.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String CLAVE_REGISTERED = "is_registered"; //Static para declarar una variable a nivel de clase, final porque no va a camniar

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        SharedPreferences sharedPreferences = getSharedPreferences("User", Context.MODE_PRIVATE); //Se crear un fichero user.xml en un directorio de la aplicacion
        Boolean isRegistered = sharedPreferences.getBoolean(CLAVE_REGISTERED, false); //Cada vez que el usuario se meta en la aplicacion cojo un numero y lo sumo
        //Si la clave "CLAVE_REGISTERED" no existe is_registered toma como valor FALSE

        System.out.print(isRegistered);

        if (!isRegistered) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(CLAVE_REGISTERED, true);
            editor.commit(); //Para confirmar los cambios


        } else {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            //Intent registered = new Intent(this, Main2Activity.class);
            //startActivity(registered);
        }

        Log.d(getClass().getCanonicalName(), "REGISTERED = " + isRegistered); //Canonical name para poder filtrar el log


    }
}

