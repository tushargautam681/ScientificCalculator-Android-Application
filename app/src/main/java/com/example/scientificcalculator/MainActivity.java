package com.example.scientificcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView tvDisplay;
    private TextView tvHistory;
    private StringBuilder input = new StringBuilder();
    private Map<Integer, String> buttonValues = new HashMap<>();
    private List<String> history = new ArrayList<>();
    private static final int MAX_HISTORY = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
        tvHistory = findViewById(R.id.tvHistory);
        setupButtonValues();
        setupButtons();
    }

    private void setupButtonValues() {
        buttonValues.put(R.id.btn0, "0");
        buttonValues.put(R.id.btn1, "1");
        buttonValues.put(R.id.btn2, "2");
        buttonValues.put(R.id.btn3, "3");
        buttonValues.put(R.id.btn4, "4");
        buttonValues.put(R.id.btn5, "5");
        buttonValues.put(R.id.btn6, "6");
        buttonValues.put(R.id.btn7, "7");
        buttonValues.put(R.id.btn8, "8");
        buttonValues.put(R.id.btn9, "9");
        buttonValues.put(R.id.btnDot, ".");
        buttonValues.put(R.id.btnPlus, "+");
        buttonValues.put(R.id.btnMinus, "-");
        buttonValues.put(R.id.btnMultiply, "*");
        buttonValues.put(R.id.btnDivide, "/");
        buttonValues.put(R.id.btnLeftParen, "(");
        buttonValues.put(R.id.btnRightParen, ")");
        buttonValues.put(R.id.btnPercent, "%");
        buttonValues.put(R.id.btnPower, "^");
        buttonValues.put(R.id.btnSqrt, "sqrt(");
        buttonValues.put(R.id.btnSin, "sin(");
        buttonValues.put(R.id.btnCos, "cos(");
        buttonValues.put(R.id.btnTan, "tan(");
        buttonValues.put(R.id.btnLog, "log(");
        buttonValues.put(R.id.btnLn, "ln(");
        buttonValues.put(R.id.btnPi, "3.141592653589793");
        buttonValues.put(R.id.btnE, "2.718281828459045");
    }

    private void setupButtons() {
        for (int id : buttonValues.keySet()) {
            Button btn = findViewById(id);
            btn.setOnClickListener(v -> {
                input.append(buttonValues.get(id));
                tvDisplay.setText(input.toString());
            });
        }
        findViewById(R.id.btnClear).setOnClickListener(v -> {
            input.setLength(0);
            tvDisplay.setText("0");
        });
        findViewById(R.id.btnDel).setOnClickListener(v -> {
            if (input.length() > 0) {
                input.setLength(input.length() - 1);
                tvDisplay.setText(input.length() == 0 ? "0" : input.toString());
            }
        });
        findViewById(R.id.btnEquals).setOnClickListener(v -> {
            try {
                double result = ExpressionEvaluator.evaluate(input.toString());
                String expr = input.toString();
                tvDisplay.setText(String.valueOf(result));
                addToHistory(expr + " = " + result);
                input.setLength(0);
            } catch (Exception e) {
                tvDisplay.setText("Error");
            }
        });
    }

    private void addToHistory(String entry) {
        if (history.size() >= MAX_HISTORY) {
            history.remove(0);
        }
        history.add(entry);
        StringBuilder sb = new StringBuilder();
        for (String s : history) {
            sb.append(s).append("\n");
        }
        tvHistory.setText(sb.toString());
    }
}
