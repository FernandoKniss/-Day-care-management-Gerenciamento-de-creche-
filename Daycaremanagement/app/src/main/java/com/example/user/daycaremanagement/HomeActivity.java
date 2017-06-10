package com.example.user.daycaremanagement;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.example.user.daycaremanagement.R;
import com.example.user.daycaremanagement.dao.Consulta;
import com.example.user.daycaremanagement.dao.InsereDado;

import java.io.File;

import static com.example.user.daycaremanagement.R.id.cadastro;
import static com.example.user.daycaremanagement.R.id.informacoes;
import static com.example.user.daycaremanagement.R.id.valor;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageButton imageButton;
    private ImageButton imageButton2;
    private ImageButton imageButton3;

    private static final int CAPTURAR_IMAGEM = 1;
    private Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageButton = (ImageButton) findViewById(cadastro);
        imageButton.setOnClickListener(this);
        imageButton2 = (ImageButton) findViewById(R.id.informacoes);
        imageButton2.setOnClickListener(this);
        imageButton3 = (ImageButton) findViewById(R.id.valor);
        imageButton3.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent i = null;
        switch (view.getId()) {
            case cadastro:
                i = new Intent(this, InsereDado.class);
                break;
            case informacoes:
                i = new Intent(this, Consulta.class);
                break;
            case valor:
                i = new Intent(this, null);
                break;
        }
        if (i != null) {
            startActivity(i);
        }

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences:
                camera();
                break;
            case R.id.galeria:
                galeria();
                break;
            case R.id.settings:
                fechar();
                break;
            default:
                break;
        }
        return true;
    }

    public void camera() {
        boolean temCamera = getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA);
        if(temCamera){

            File diretorio = Environment
                    .getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES);

            String nomeImagem = diretorio.getPath() + "/" +
                    System.currentTimeMillis() +
                    ".jpg";

            uri = Uri.fromFile(new File(nomeImagem));
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            startActivityForResult(intent, CAPTURAR_IMAGEM);

            Intent in2 = new Intent(
                    Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            in2.setData(uri);
            this.sendBroadcast(in2);
        }
    }

    public void fechar() {
        //Metodo para fechar as activity
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

    private void galeria(){
        Intent intent = new Intent(getApplicationContext(), ImageGaleriaActivity.class);
        startActivity(intent);
    }


}