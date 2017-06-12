package com.example.user.daycaremanagement;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ValoresActivity extends AppCompatActivity {

    private EditText editnumber1, editnumber2, editnumber3;
    private Button somar;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valores);

        imageButton = (ImageButton) findViewById(R.id.voltar);

        editnumber1 = (EditText) findViewById(R.id.valorMensalidade);
        editnumber2 = (EditText) findViewById(R.id.valorAlimentacao);
        editnumber3 = (EditText) findViewById(R.id.valorAdicional);
        Button somar = (Button) findViewById(R.id.somar);

        somar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                double num1 = Double.parseDouble(editnumber1.getText().toString());
                double num2 = Double.parseDouble(editnumber2.getText().toString());
                double num3 = Double.parseDouble(editnumber3.getText().toString());
                // o resultado da soma dos dois numeros
                double res = num1 + num2 + num3;
                // preparando AlertDialog: instanciando e setando valores o objeto AlertDialog
                // Instância
                AlertDialog.Builder dialogo = new AlertDialog.Builder(ValoresActivity.this);
                // setando título
                dialogo.setTitle("Resultado");
                // setando mensagem
                dialogo.setMessage("Soma: " + res);
                // setando botão
                dialogo.setNeutralButton("OK", null);
                // chamando o AlertDialog
                dialogo.show();
            }
        });
    }

    public void Voltar(View v){
        finish();

    }
}
