package com.example.user.daycaremanagement;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ImageGaleriaActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private Bitmap bitmap;
    private ImageView imageView;
    private ImageButton imageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_galeria);

        imageView = (ImageView) findViewById(R.id.result);
        imageButton = (ImageButton) findViewById(R.id.voltar);

    }
    public void galeria(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(intent.CATEGORY_OPENABLE);

        startActivityForResult(intent, REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
            try {

                if (bitmap != null) {
                    bitmap.recycle();
                }
                stream = getContentResolver().openInputStream(data.getData());
                bitmap = BitmapFactory.decodeStream(stream);

                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (stream != null)
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
    }

    public void onClick(View v){
        finish();

    }
}

