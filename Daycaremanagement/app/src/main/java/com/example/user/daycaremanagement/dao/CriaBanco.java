package com.example.user.daycaremanagement.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 29/05/2017.
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.creche";
    public static final String TABELA = "Aluno";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String DT_NASCIMENTO = "dt_nascimento";
    public static final String MATRICULA = "matricula";
    public static final String OBSERVACAO = "observacao";
    public static final int VERSAO = 2;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase creche) {

        creche.execSQL("CREATE TABLE " + TABELA + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NOME + " text,"
                + DT_NASCIMENTO + " text,"
                + MATRICULA + " text,"
                + OBSERVACAO + " text"
                +");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase creche, int oldVersion, int newVersion) {
        creche.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(creche);
    }
}
