package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText exNum1, exNum2, exOperation;
    private TextView tvResultText;
    private Button btnCalculateResult;
    private Toast toastError;
    static boolean correctOperation;

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
        Float result;
        float numberInputOne, numberInputTwo;
        String taskOperation;

        try {
            numberInputOne = Float.parseFloat(exNum1.getText().toString());
            numberInputTwo = Float.parseFloat(exNum2.getText().toString());
            taskOperation = exOperation.getText().toString();
            var logicCalc = new LogicCalc();

            result = logicCalc.logicCalc(taskOperation, numberInputOne, numberInputTwo);

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
            tvResultText.setText(numberInputOne + " " + taskOperation + " " + numberInputTwo + " = " + result);

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