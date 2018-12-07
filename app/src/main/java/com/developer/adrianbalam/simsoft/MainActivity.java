package com.developer.adrianbalam.simsoft;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  //Declaración de View's como objetos...
  EditText et1,et2,et3,et4;
  double datosRecolectados[];
  String varObservadaX;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Instanciación de View's como objetos...
    et1=(EditText) findViewById(R.id.et1);
    et2=(EditText) findViewById(R.id.et2);
    et3=(EditText) findViewById(R.id.et3);
    et4=(EditText) findViewById(R.id.et4);
    datosRecolectados=new double[3];

  }

  public void recuperarDatosFormulario(View v){
    //Recolectando datos de los EditText al arreglo de datos...
    varObservadaX=et1.getText().toString().trim();
    datosRecolectados[0]=Double.parseDouble(et2.getText().toString().trim());
    datosRecolectados[1]=Double.parseDouble(et3.getText().toString().trim());
    datosRecolectados[2]=Double.parseDouble(et4.getText().toString().trim());
    if(!et1.equals("") && !et2.equals("") && !et3.equals("") && !et4.equals("")){
      irResultadosActivity(varObservadaX, datosRecolectados);
    }
  }

  public void irResultadosActivity(String varObservadaX, double datosRecolectados[]){
    Intent irResultados=new Intent(this,ResultadosActivity.class);
    irResultados.putExtra("x",varObservadaX);
    irResultados.putExtra("datos",datosRecolectados);
    startActivity(irResultados);
  }

}