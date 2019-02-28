package ifpr.tads.josepher.calculadoradegorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraGorjetaActivity extends AppCompatActivity {
    private SeekBar seekBarPorcentagem;
    private TextView nivelPorcentagem;
    private TextView gorjeta1;
    private TextView total1;
    private TextView valorGasto1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_gorjeta);
        initializeVariables();

        nivelPorcentagem.setText(seekBarPorcentagem.getProgress()+"%");
//        valorGasto1.addTextChangedListener(this);

        seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           int progress = 0;

           @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                //Toast.makeText(getApplicationContext(),"sla",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(),"sla2",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                nivelPorcentagem.setText(progress+"%");
                calcular(progress);
                //Toast.makeText(getApplicationContext(),"sla3",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initializeVariables(){
        seekBarPorcentagem = (SeekBar) findViewById(R.id.seekBarPorcentagem1);
        nivelPorcentagem = (TextView) findViewById(R.id.nivelPorcentagem1);
        total1 = (TextView) findViewById(R.id.total);
        gorjeta1 = (TextView) findViewById(R.id.gorjeta);
        valorGasto1 = (TextView) findViewById(R.id.valorGasto);

    }
    private Double calcular(int progress){
        float p = 0;
        float cem = 100;
        float vgo = 0;
        float t = 0.0f;
        float vga = Float.parseFloat(valorGasto1.getText().toString());

        p = progress / cem;
        vgo = p*vga;
        t = vga+vgo;

        gorjeta1.setText("R$ "+vgo);
        total1.setText("R$ "+t);
        return null;
    }
}
