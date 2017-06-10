package com.example.user.daycaremanagement.dao;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.user.daycaremanagement.Alterar;
import com.example.user.daycaremanagement.R;

import static com.example.user.daycaremanagement.R.layout.alterar;

/**
 * Created by User on 29/05/2017.
 */

public class Consulta extends Activity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        final BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{CriaBanco.ID, CriaBanco.NOME};
        int[] idViews = new int[]{R.id.idAluno, R.id.nomeAluno};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.alunos_layout, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String codigo;
                cursor.moveToPosition(position);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID));
                Intent intent = new Intent(Consulta.this, Alterar.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}