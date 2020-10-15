package com.chilisin.wms_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.os.Bundle;
import android.view.View;


public class Login extends AppCompatActivity {
    private String xFactory;
    private String xFactoryID;
    @Override
    @SuppressLint("NewApi")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //ImageView bk = findViewById(R.id.rl1);

        Spinner spinner = (Spinner)findViewById(R.id.spnFactory);
        final String[] pFab = {"奇力新總部", "東莞奇力新", "湖南奇力新", "越南奇力新"};
        final String[] pFabID= {"A000", "C100", "C200", "D100"};
        ArrayAdapter<String> pFabList = new ArrayAdapter <>(Login.this,
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
                i.setClass(Login.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
    public void checkLoginUser(View view) {
        EditText xuid = (EditText) findViewById(R.id.txtUID);
        EditText xpwd = (EditText) findViewById(R.id.txtPWD);
        RadioGroup rg = (RadioGroup)findViewById(R.id.rectangles);
        String xarea = "測試區";
        //依選取項目顯示不同訊息
        switch(rg.getCheckedRadioButtonId()){
            case R.id.rdoprod:
                xarea="正式區";
                break;
            case R.id.rdotest:
                xarea="測式區";
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putString("uid",xuid.getText().toString());
        bundle.putString("factoryid",xFactoryID);
        bundle.putString("factory",xFactory);
        bundle.putString("sysarea",xarea);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(Login.this, MainActivity.class);
        startActivity(intent);
        //Login.this.finish();

    }


    private void showMsg(String xmsg){
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(Login.this);
        dialog.setTitle("訊息");
        dialog.setMessage(xmsg);
        dialog.setNegativeButton("確定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }

        });

        dialog.setNeutralButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }

        });
        dialog.show();

    }
}