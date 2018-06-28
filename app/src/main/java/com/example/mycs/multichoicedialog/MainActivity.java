package com.example.mycs.multichoicedialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    AlertDialog.Builder alertDialogBuilder;
    String[] alertDialogItems = new String[] {
            "美味蟹堡", "義式香腸堡", "蔬菜水果堡", "香蕉潛艇堡", "香烤雞腿堡"
    };

    List<String> itemsIntoList;

    boolean[] selected = new boolean[] {
            false, false, false, false, false
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                itemsIntoList = Arrays.asList(alertDialogItems);
                alertDialogBuilder.setMultiChoiceItems(alertDialogItems, selected, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {

                    }
                });
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setTitle("您點的餐點有：");
                alertDialogBuilder.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int index = 0;
                        while (index < selected.length) {
                            boolean value = selected[index];
                            if (value) {
                                textView.setText(String.format("%s%s\n", textView.getText(), itemsIntoList.get(index)));
                            }
                            index++;
                        }
                    }
                });
                alertDialogBuilder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog diaLog = alertDialogBuilder.create();
                diaLog.show();
            }
        });
    }
}
