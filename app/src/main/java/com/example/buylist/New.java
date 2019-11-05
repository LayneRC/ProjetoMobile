package com.example.buylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class New extends AppCompatActivity {

    private SeekBar seek;
    private TextView txtSeek;
    private EditText nome;
    private SeekBar prioridade;
    private Button addBtn;

    DatabaseReference refData;
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        final NumberPicker np = findViewById(R.id.QuantidadeID);
        nome = findViewById(R.id.NomeID);
        prioridade = findViewById(R.id.PrioridadeID);
        addBtn = findViewById(R.id.AddBtn);

        refData = FirebaseDatabase.getInstance().getReference().child("Item");
        item = new Item();

        np.setMinValue(1);
        np.setMaxValue(100);

        np.setWrapSelectorWheel(true);

        seek = findViewById(R.id.PrioridadeID);
        txtSeek = findViewById(R.id.TxtSeekID);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                int sliderValue = progress;
                if (sliderValue == 0) {
                    txtSeek.setText("Pouco importante");
                }else if (sliderValue == 1){
                    txtSeek.setText("Importante");
                }else if (sliderValue == 2){
                    txtSeek.setText("Muito importante");
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int npDB = np.getValue();


                item.setNomeItem(nome.getText().toString().trim());
                item.setQuantidade(npDB);
                item.setPrioridade(seek.getProgress());

                refData.push().setValue(item);
                Toast.makeText(New.this, "Adicionado com sucesso!", Toast.LENGTH_LONG).show();




            }
        });

    }
}
