package com.example.user.daycaremanagement.dao;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.daycaremanagement.R;

/**
 * Created by User on 29/05/2017.
 */

public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incial_activity);

        Button botao = (Button)findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud = new BancoController(getBaseContext());
                EditText nome = (EditText)findViewById(R.id.editText);
                EditText dtNascimento = (EditText)findViewById((R.id.editText2));
                EditText matricula = (EditText)findViewById(R.id.editText3);
                EditText obsercao = (EditText) findViewById(R.id.editText5);
                String nomeString = nome.getText().toString();
                String dtNascimentoString = dtNascimento.getText().toString();
                String matriculaString = matricula.getText().toString();
                String observacaoString = obsercao.getText().toString();
                String resultado;

                resultado = crud.insereDado(nomeString, dtNascimentoString, matriculaString, observacaoString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}