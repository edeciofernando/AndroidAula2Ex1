package br.com.edecio.centronutricao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNome;
    private EditText edtAltura;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btCalcular;
    private Button btLimpar;
    private TextView txtResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        btCalcular = (Button) findViewById(R.id.btCalcular);
        btLimpar = (Button) findViewById(R.id.btLimpar);
        txtResposta = (TextView) findViewById(R.id.txtResposta);

        btCalcular.setOnClickListener(this);
        btLimpar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // se clicou no calcular
        if (v.getId() == R.id.btCalcular) {
            String nome = edtNome.getText().toString();
            String alt = edtAltura.getText().toString();
            boolean masc = rbMasculino.isChecked();
            boolean fem = rbFeminino.isChecked();

            if (nome.trim().isEmpty() || alt.trim().isEmpty() ||
                    (!masc && !fem)) {
                Toast.makeText(this, "Preencha os dados", Toast.LENGTH_LONG).show();
                edtNome.requestFocus();
                return;
            }

            double altura = Double.parseDouble(alt);
            double peso;
            if (masc) {
                peso = 72.7 * altura - 58;
            } else {
                peso = 62.1 * altura - 44.7;
            }
            txtResposta.setText(nome+" seu peso ideal é "+peso+" Kg");
        } else {
            edtNome.setText("");
            edtAltura.setText("");
            rbMasculino.setChecked(false);
            rbFeminino.setChecked(false);
            txtResposta.setText("");
            edtNome.requestFocus();
        }
    }
}
