package com.abucay.labexer_nov0917;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etData;
    EditText etFilename;
    Button btnNext, btnShared, btnInternalStorage, btnInternalCache, btnExternalCache, btnExternalStorage, btnExternalPublic;
    SharedPreferences preferences;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = (EditText) findViewById(R.id.etData);
        etFilename = (EditText) findViewById(R.id.etFilename);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnShared = (Button) findViewById(R.id.btnShared);

        preferences = getSharedPreferences("Preferences", Context.MODE_PRIVATE);

    }

    public void sharedPref(View view){

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("data", etData.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();

    }

    public void internalStorage(View view){

        String message = etData.getText().toString();

        try{
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(message.getBytes());
            fos.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally{
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }

        }
        Toast.makeText(this, "Message Saved!", Toast.LENGTH_SHORT).show();
    }

    public void saveInternalCache(View view){

        File folder = getCacheDir();
        File file = new File(folder, "output1.txt");
        String message = etData.getText().toString();
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Successfully written to Internal Cache!", Toast.LENGTH_SHORT).show();
    }

    public void saveExternalCache(View view){
        File folder = getExternalCacheDir();
        File file = new File(folder, "output2.txt");
        FileOutputStream fos = null;
        String message = etData.getText().toString();
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Successfully written to External Cache!", Toast.LENGTH_SHORT).show();
    }

    public void saveExternalStorage(View view){
        File folder = getExternalFilesDir("Downloads");
        File file = new File(folder, "output3.txt");
        FileOutputStream fos = null;
        String message = etData.getText().toString();
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Successfully written to External Storage!", Toast.LENGTH_SHORT).show();
    }

    public void saveExternalPublic(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "output4.txt");
        FileOutputStream fos = null;
        String message = etData.getText().toString();
        try{
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "Successfully written to External Public!", Toast.LENGTH_SHORT).show();
    }



    public void nextWindow(View view){
        Intent intent = new Intent(this, SecondActivity.class);

        startActivity(intent);
    }




}
