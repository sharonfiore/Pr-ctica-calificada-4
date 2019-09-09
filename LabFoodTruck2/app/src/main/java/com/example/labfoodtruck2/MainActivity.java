package com.example.labfoodtruck2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvmensajee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String action =intent.getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type!=null){
            if("text/plain".equals(type)){
                manipularTexto(intent);
            }
        }
    }

    public void manipularTexto (Intent intent){
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(sharedText != null){

            tvmensajee = (TextView)findViewById(R.id.tv_mensaje);

            tvmensajee.setText(sharedText);

            Toast.makeText(MainActivity.this,sharedText,Toast.LENGTH_LONG).show();
        }
    }
}
