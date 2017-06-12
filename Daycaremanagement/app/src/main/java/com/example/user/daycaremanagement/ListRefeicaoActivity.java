package com.example.user.daycaremanagement;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListRefeicaoActivity extends AppCompatActivity {

    public ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_refeicao);

        String[] informacoes = new String[] {String.valueOf(R.id.cafeDaManha), String.valueOf(R.id.almoco),
                String.valueOf(R.id.jantar)};
        int[] idViews = new int[]{R.id.cafeDaManha, R.id.almoco, R.id.jantar};

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, informacoes);
            list = (ListView) findViewById(R.id.list);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View view,
                                        int position, long id) {
                    AlertDialog.Builder mensagem = new AlertDialog.Builder(
                            ListRefeicaoActivity.this);
                    mensagem.setTitle("Cardápio pronto: ");
                    mensagem.setMessage(((TextView) view).getText().toString());
                    mensagem.setNeutralButton("OK", null);
                    mensagem.show();

                }
            });
        }



    }
