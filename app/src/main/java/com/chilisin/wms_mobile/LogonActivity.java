package com.chilisin.wms_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class LogonActivity extends AppCompatActivity {
    private String xFactory;
    private String xFactoryID;
    @Override
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logon);

        Spinner spinner = (Spinner)findViewById(R.id.spnFactory);
        final String[] pFab = {"奇力新總部", "東莞奇力新", "湖南奇力新", "越南奇力新"};
        final String[] pFabID= {"A000", "C100", "C200", "D100"};
        ArrayAdapter<String> pFabList = new ArrayAdapter <>(LogonActivity.this,
                android.R.layout.simple_spinner_dropdown_item,
                pFab);
        spinner.setAdapter(pFabList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                xFactory = pFab[position];
                xFactoryID = pFabID[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button b1 = (Button) findViewById(R.id.btnLogin);
        b1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent();
                i.setClass(LogonActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}