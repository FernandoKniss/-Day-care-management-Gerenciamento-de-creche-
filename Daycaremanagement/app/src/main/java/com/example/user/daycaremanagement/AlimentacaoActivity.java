package com.example.user.daycaremanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlimentacaoActivity extends AppCompatActivity {

    EditText editText, editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentacao);

        editText = (EditText) findViewById(R.id.cafeDaManha);
        editText1 = (EditText) findViewById(R.id.almoco);
        editText2 = (EditText) findViewById(R.id.jantar);


        button = (Button) findViewById(R.id.gravarRefeicao);

    }

    public void onClick (View view) {

        Intent intent = new Intent(this, ListRefeicaoActivity.class);
        startActivity(intent);

    }
}
