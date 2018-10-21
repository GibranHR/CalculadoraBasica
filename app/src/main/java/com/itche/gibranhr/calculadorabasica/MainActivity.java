package com.itche.gibranhr.calculadorabasica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,
            btnBorrar,btnresta,btnsuma,btnigual,btnmulti,btndivi;

    TextView edtResul;
    public float valor1, valor2, resultado;
    char signo;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pantalla
        edtResul = (TextView)findViewById(R.id.edtResul);

        //funciones
        btnBorrar = (Button)findViewById(R.id.btnBorrar);
        btnigual = (Button)findViewById(R.id.btnigual);

        OyenteClic objDetectaClic = new OyenteClic();
        OyenteSigno objDetectaSigno = new OyenteSigno();

        //operadores
        btnsuma = (Button)findViewById(R.id.btnsuma);
        btnsuma.setOnClickListener(objDetectaSigno);

        btnresta = (Button)findViewById(R.id.btnresta);
        btnresta.setOnClickListener(objDetectaSigno);

        btnmulti = (Button)findViewById(R.id.btnmulti);
        btnmulti.setOnClickListener(objDetectaSigno);

        btndivi = (Button)findViewById(R.id.btndivi);
        btndivi.setOnClickListener(objDetectaSigno);

        //Botón 1
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(objDetectaClic);

        //Botón 2
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(objDetectaClic);

        //Botón 3
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(objDetectaClic);

        //Botón 4
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(objDetectaClic);

        //Botón 5
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(objDetectaClic);

        //Botón 6
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(objDetectaClic);

        //Botón 7
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(objDetectaClic);

        //Botón 8
        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(objDetectaClic);

        //Botón 9
        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(objDetectaClic);

        //Botón 0
        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(objDetectaClic);

        //Borrar
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtResul.setText("");
                resultado=0;
            }
        });
    }
    //Guarda el primer valor
    public void onClickOperacionCapturaNumero1(View view) {
        valor1=Float.parseFloat(edtResul.getText().toString());
        edtResul.setText("0");
    }

    //Mostrar resultado
    public void igual(View view){

        valor2=Float.parseFloat(edtResul.getText().toString());

        //Verifica el operador
        switch (signo){
            case '+':
                resultado= valor1+valor2;
                break;
            case '-':
                resultado= valor1-valor2;
                break;
            case 'x':
                resultado= valor1*valor2;
                break;
            case '/':
                resultado= valor1/valor2;
                break;
        }
        edtResul.setText(String.valueOf(resultado));
        valor1=0;
        valor2=0;
    }
    //Metodo de los botones en una clase para todos
    class OyenteClic implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            edtResul = (TextView) findViewById(R.id.edtResul);
            if(edtResul.getText().equals("0")) {
                edtResul.setText(((Button)v).getText());
            }else if(edtResul.getText().equals(String.valueOf(resultado))) {
                edtResul.setText(((Button)v).getText());
                resultado = 0;
            }else{
                edtResul.setText(edtResul.getText() + ((Button)v).getText().toString());
            }
        }
    }//OyenteClick

    //Metodo de los botones en una clase para todos
    class OyenteSigno implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            edtResul = (TextView) findViewById(R.id.edtResul);
            if(edtResul.getText().toString().trim().length()==0){
                edtResul.setText(null);
            }else{
                signo = ((Button)v).getText().toString().charAt(0);
                onClickOperacionCapturaNumero1(v);
            }
        }
    }//OyenteSgino
}//MainClass