package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText exNum1, exNum2, exOperation;
    private TextView tvResultText;
    private Button btnCalculateResult;
    private Toast toastError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exNum1 = findViewById(R.id.num1_edit_text);
        exNum2 = findViewById(R.id.num2_edit_text);
        exOperation = findViewById(R.id.operation_edit_view);
        tvResultText = findViewById(R.id.result_text_view);
        btnCalculateResult = findViewById(R.id.calculate_result_button);
        btnCalculateResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float result = 0;
        boolean correctOperation = true;


        try {
            float numberInputOne = Float.parseFloat(exNum1.getText().toString());
            float numberInputTwo = Float.parseFloat(exNum2.getText().toString());
            String taskOperation = exOperation.getText().toString();

            switch (taskOperation) {
                case "+":
                    result = numberInputOne + numberInputTwo;
                    break;
                case "-":
                    result = numberInputOne - numberInputTwo;
                    break;
                case "*":
                    result = numberInputOne * numberInputTwo;
                    break;
                case "/":
                    if (numberInputTwo == 0) throw new ArithmeticException();
                    result = numberInputOne / numberInputTwo;
                    break;
                default:
                    correctOperation = false;
                    break;
            }
        } catch (ArithmeticException e) {
            int duration = Toast.LENGTH_LONG;
            if (toastError != null) {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.divide_zero, duration);
            toastError.show();
            return;

        } catch (NullPointerException e) {
            int duration = Toast.LENGTH_LONG;
            if (toastError != null) {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.null_data, duration);
            toastError.show();
            return;

        } catch (NumberFormatException e) {
            int duration = Toast.LENGTH_LONG;
            if (toastError != null) {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.wrong_format, duration);
            toastError.show();
            return;
        }
        if (correctOperation) {
            tvResultText.setText(""+ result);

        } else {
            int duration = Toast.LENGTH_LONG;
            if (toastError != null) {
                toastError.cancel();
            }
            toastError = Toast.makeText(this, R.string.wrong_operation, duration);
            toastError.show();
            return;
        }
    }
}