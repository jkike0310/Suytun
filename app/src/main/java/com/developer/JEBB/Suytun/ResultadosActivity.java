package com.developer.JEBB.Suytun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import java.util.ArrayList;

public class ResultadosActivity extends AppCompatActivity {

    //Declaración de objetos...
    Bundle bundleResultados;
    RelativeLayout rlDatos;
    String varObservadaX;
    double datosRecolectados[];
    TableLayout tablaResultados;
    private String categorias[]={"No. Proceso","No. Aleatorio","X"};
    private ArrayList<double[]> filas=new ArrayList<>();
    private double numAleatorios[];
    private double tiemposServicio[];
    TablaDinamicaResultados tablaDinamicaResultados;
    EditText etTiempo;
    int contador2=0;
    double tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        //Instanciación de View's como objetos...
        tablaResultados=(TableLayout) findViewById(R.id.tablaResultados);
        etTiempo=(EditText) findViewById(R.id.etTiempo);
        bundleResultados=getIntent().getExtras();
        rlDatos=(RelativeLayout) findViewById(R.id.rlDatos);
        tablaDinamicaResultados=new TablaDinamicaResultados(tablaResultados,getApplicationContext());
        tablaDinamicaResultados.addCategorias(categorias);

        //Ejecución de los métodos de la clase...
        obtenerDatosVariablesAleatorias();
        tablaDinamicaResultados.addDatos(obtenerDatos());

    }

    public void obtenerDatosVariablesAleatorias(){
        //Obteniendo los datos definidos en el formulario del método de solución...
        varObservadaX=bundleResultados.getString("x");
        datosRecolectados=bundleResultados.getDoubleArray("datos");
        numAleatorios=new double[(int)datosRecolectados[2]];
        tiemposServicio=new double[(int)datosRecolectados[2]];
    }

    public void addNuevoDato(View view){
        tiempo=Double.parseDouble(etTiempo.getText().toString().trim());
        if(contador2<datosRecolectados[2]){
            double item[]=new double[]{contador2+1,(Math.random()*(1-0+1)+0),tiempo};
            numAleatorios[contador2]=item[1];
            tiemposServicio[contador2]=item[2];
            tablaDinamicaResultados.addItems(item);
            contador2++;
        }else{
            //Que hacer cuando ya tiene todos los datos...
            rlDatos.setVisibility(View.GONE);//Desaparece el formulario para añadir más datos...
        }
    }

    private ArrayList<double[]> obtenerDatos(){
        for(int cont=0;cont<datosRecolectados[2];cont++){
            filas.add(new double[]{(cont+1),(Math.random()*(1-0+1)+0),0});
        }
        return filas;
    }
}
