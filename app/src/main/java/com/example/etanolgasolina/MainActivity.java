package com.example.etanolgasolina;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvResultado;
    EditText etGasolina;
    EditText etEtanol;
    Button btCalcular;
    Button btLimpar;

    double precoGasolina;
    double precoEtanol;
    double resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tvResultado = findViewById(R.id.tvResultado);
        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        btCalcular = findViewById(R.id.btCalcular);
        btLimpar = findViewById(R.id.btLimpar);

        btCalcular.setOnClickListener(v -> {

            precoGasolina = Double.parseDouble(etGasolina.getText().toString());
            precoEtanol = Double.parseDouble(etEtanol.getText().toString());

            resultado = precoEtanol / precoGasolina;

            if(resultado <= 0.7){
                tvResultado.setText("Melhor abastecer com: " + "Etanol");
            }else{
                tvResultado.setText("Melhor abastecer com: " + "Gasolina");
            }
        });

        btLimpar.setOnClickListener(v -> {
            resultado = 0;
            precoGasolina = 0;
            precoEtanol = 0;
            tvResultado.setText("Melhor abastecer com: ");
            etGasolina.setText("");
            etEtanol.setText("");
        });
    }
}