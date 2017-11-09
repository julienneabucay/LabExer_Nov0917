package com.abucay.labexer_nov0917;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    TextView tvData;
    SharedPreferences preferences;
    Button btnPrevious, btnShared, btnInternalStorage, btnInternalCache, btnExternalCache, btnExternalStorage, btnExternalPublic;
    FileOutputStream fos;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvData = (TextView) findViewById(R.id.tvData);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);
        btnShared = (Button) findViewById(R.id.btnShared);



        preferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
    }

    public void loadShared(View view){
        SharedPreferences preferences = this.getSharedPreferences("Preferences", MODE_PRIVATE);
        String data = preferences.getString("data","");
        tvData.setText(data);
    }

    public void loadInternal(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output.txt");
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            fis.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        tvData.setText(buffer.toString());
    }

    public void loadInternalCache(View view) {

        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output1.txt");
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            fis.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        tvData.setText(buffer.toString());

    }

    public void loadExternalCache(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output2.txt");
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            fis.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        tvData.setText(buffer.toString());
    }

    public void loadExternalStorage(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output3.txt");
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            fis.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        tvData.setText(buffer.toString());
    }

    public void loadExternalPublic(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output4.txt");
            while ((read = fis.read()) != -1) {
                buffer.append((char) read);
            }
            fis.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        tvData.setText(buffer.toString());
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);;
        startActivity(intent);
    }

}
