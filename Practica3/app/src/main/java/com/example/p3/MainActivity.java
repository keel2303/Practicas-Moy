package com.example.p3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox cb1, cb2, cb3;
    RadioGroup rgOptions;
    RadioButton rbChoice1, rbChoice2, rbChoice3;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = findViewById(R.id.cbOption1);
        cb2 = findViewById(R.id.cbOption2);
        cb3 = findViewById(R.id.cbOption3);

        rgOptions = findViewById(R.id.rgOptions);
        rbChoice1 = findViewById(R.id.rbChoice1);
        rbChoice2 = findViewById(R.id.rbChoice2);
        rbChoice3 = findViewById(R.id.rbChoice3);

        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder result = new StringBuilder();

                result.append("Checkbox seleccionados:\n");
                if (cb1.isChecked()) result.append("- ").append(cb1.getText()).append("\n");
                if (cb2.isChecked()) result.append("- ").append(cb2.getText()).append("\n");
                if (cb3.isChecked()) result.append("- ").append(cb3.getText()).append("\n");
                if (!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()) {
                    result.append("Ninguno\n");
                }

                int selectedRadioId = rgOptions.getCheckedRadioButtonId();
                result.append("\nRadio seleccionado: ");
                if (selectedRadioId == rbChoice1.getId()) {
                    result.append(rbChoice1.getText());
                } else if (selectedRadioId == rbChoice2.getId()) {
                    result.append(rbChoice2.getText());
                } else if (selectedRadioId == rbChoice3.getId()) {
                    result.append(rbChoice3.getText());
                } else {
                    result.append("Ninguno");
                }

                tvResult.setText(result.toString());
            }
        });
    }
}
