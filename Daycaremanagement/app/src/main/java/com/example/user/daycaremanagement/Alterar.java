package com.example.user.daycaremanagement;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.daycaremanagement.R;
import com.example.user.daycaremanagement.dao.BancoController;
import com.example.user.daycaremanagement.dao.Consulta;
import com.example.user.daycaremanagement.dao.CriaBanco;

/**
 * Created by User on 04/06/2017.
 */

public class Alterar extends Activity {

    EditText aluno;
    EditText dt_Nascimento;
    EditText matricula;
    EditText observacao;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        aluno = (EditText) findViewById(R.id.editText5);
        dt_Nascimento = (EditText) findViewById(R.id.editText6);
        matricula = (EditText) findViewById(R.id.editText7);
        observacao = (EditText) findViewById(R.id.editText8);

        clear((ViewGroup)findViewById(R.id.Alter));

        alterar = (Button)findViewById(R.id.button2);
        deletar = (Button)findViewById(R.id.button3);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        aluno.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOME)));
        dt_Nascimento.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DT_NASCIMENTO)));
        matricula.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.MATRICULA)));
        observacao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.OBSERVACAO)));

        alterar.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            crud.alteraRegistro(Integer.parseInt(codigo), aluno.getText().toString(),dt_Nascimento.getText().toString(),
                    matricula.getText().toString(), observacao.getText().toString());
            Intent intent = new Intent(Alterar.this,Consulta.class);
            startActivity(intent);
            finish();
            }
        });

        deletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(Alterar.this,Consulta.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void clear(ViewGroup group) {

        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                clear((ViewGroup) view);
                continue;
            }
            if (view instanceof EditText) {
                ((EditText)view).setText("");
                continue;
            }
        }
    }
}
