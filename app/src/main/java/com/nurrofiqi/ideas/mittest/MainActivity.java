package com.nurrofiqi.ideas.mittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fromedit)
    EditText frominput;
    @BindView(R.id.toedit)
    EditText toinput;
    @BindView(R.id.sum)
    EditText suminput;
    @BindView(R.id.shiftbutton)
    Button shiftbutt;
    @BindView(R.id.simpleGridView)
    GridView simpleGrid;

    String chars[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
            "q", "w", "e", "r", "t", "y", "u", "i", "o", "p",
            "a", "s", "d", "f", "g", "h", "j", "k", "l", ";",
            "z", "x", "c", "v", "b", "n", "m", ",", ".", "/",};

    ArrayList<String> charas = new ArrayList<>(Arrays.asList(chars));
    ArrayList<String> temp = new ArrayList<>();

    int from, to, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final CustomAdapter customAdapter = new CustomAdapter(this, charas);
        simpleGrid.setAdapter(customAdapter);

        shiftbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(frominput.getText()).equals("")||String.valueOf(toinput.getText()).equals("")||String.valueOf(suminput.getText()).equals("")){
                    Toast.makeText(MainActivity.this, "pls fill", Toast.LENGTH_SHORT).show();
                } else {
                    from = Integer.parseInt(String.valueOf(frominput.getText()));
                    sum = Integer.parseInt(String.valueOf(suminput.getText()));
                    to = Integer.parseInt(String.valueOf(toinput.getText()));
                    Toast.makeText(MainActivity.this, "moved: "+ customAdapter.getItem(from), Toast.LENGTH_SHORT).show();
                    for (int i=0;i<sum;i++){
                        temp.add(i, (String) customAdapter.getItem(from));
                        charas.remove(from);
                    }
                    charas.addAll(to, temp);
                    temp.clear();
                    customAdapter.notifyDataSetChanged();
                }
            }
        });

    }
}
