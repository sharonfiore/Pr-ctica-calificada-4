package com.example.labfoodtruck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txtmensaje;
    CheckBox check_burger1, check_burger2, check_burger3;
    CheckBox check_pollo1, check_pollo2, check_pollo3;
    Button btnenviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtmensaje = (EditText)findViewById(R.id.edt_msj);
        btnenviar = (Button)findViewById(R.id.btn_enviar);
        check_burger1= (CheckBox)findViewById(R.id.chk_burger1);
        check_burger2= (CheckBox)findViewById(R.id.chk_burger2);
        check_burger3= (CheckBox)findViewById(R.id.chk_burger3);

        check_pollo1= (CheckBox)findViewById(R.id.chk_pollo1);
        check_pollo2= (CheckBox)findViewById(R.id.chk_pollo2);
        check_pollo3= (CheckBox)findViewById(R.id.chk_pollo3);



        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String resultado = "";
                Double precio = 0.0;
                if(check_burger1.isChecked()==true){
                    resultado =  resultado + "Big Mac .... S/.14.00" + "\n";
                    precio = precio + 14;
                }
                if(check_burger2.isChecked()==true){
                    resultado =  resultado + "Cuarto de Libra  .... S/.14.50" + "\n";
                    precio = precio + 14.50;
                }
                if(check_burger3.isChecked()==true){
                    resultado =  resultado + "Doble Extra de Carne  .... S/.15.00" + "\n";
                    precio = precio + 15;
                }
                if(check_pollo1.isChecked()==true){
                    resultado =  resultado + "Pollo Crujiente 2pz. .... S/.12.00" + "\n";
                    precio = precio + 12;
                }
                if(check_pollo2.isChecked()==true){
                    resultado =  resultado + "McPollo .... S/.14.00" + "\n";
                    precio = precio + 14;
                }
                if(check_pollo3.isChecked()==true){
                    resultado =  resultado + "McNuggets .... S/.14.00" + "\n";
                    precio = precio + 14;
                }

                String pedido = "PEDIDO DE: " + txtmensaje.getText().toString() +" \n \n" + resultado
                        +"\nTotal: " + precio;

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, pedido);
                sendIntent.setType("text/plain");

                if(null != sendIntent.resolveActivity(getPackageManager())){
                    startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send_to)));
                }
            }
        });
    }
}
