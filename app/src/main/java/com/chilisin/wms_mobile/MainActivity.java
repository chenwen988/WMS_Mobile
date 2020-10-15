package com.chilisin.wms_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private TextView tuid;
    private TextView tfactory;
    private TextView tsysarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /*
        Bundle bundle = this.getIntent().getExtras();
        tuid = (TextView) findViewById(R.id.tvuid);
        tfactory = (TextView) findViewById(R.id.tvfactory);
        tsysarea = (TextView) findViewById(R.id.tvsysarea);
        if(bundle!=null)
        {
            tuid.setText(bundle.getString("uid"));
            tfactory.setText(bundle.getString("factoryid"));
            tsysarea.setText(bundle.getString("sysarea"));
        }
        */

        int[] image = {  R.drawable.movein, R.drawable.moveout, R.drawable.stockmove,R.drawable.inspected,R.drawable.checklist, R.drawable.search };
        final String[] imgText = { "入庫(上架)","出貨(下架)","移倉","檢驗", "出貨包裝","查詢" };

        CustomGrid adapter = new CustomGrid(MainActivity.this, imgText, image);
        gridView = (GridView) findViewById(R.id.grdmenu);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //[+position] +的功用是?
                Toast.makeText(MainActivity.this, "你選取了" + imgText[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showMsg(String xmsg){
        android.app.AlertDialog.Builder dialog = new android.app.AlertDialog.Builder(MainActivity.this);
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