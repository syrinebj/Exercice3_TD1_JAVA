package com.example.exemple;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button google, wiki, android;
    EditText rech;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            google = findViewById(R.id.google);
            wiki = findViewById(R.id.wikipedia);
            android = findViewById(R.id.android);
            rech = findViewById(R.id.text);

            google.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                    String recherche = rech.getText().toString();
                    intent.putExtra(SearchManager.QUERY,recherche );
                    startActivity(intent);
                }
            });
    }

    public void wiki(View view){
        String recherche = rech.getText().toString();
        Uri chemin = Uri.parse("https://fr.m.wikipedia.org/w/index.php?search=" +recherche+"&title=Sp%C3%A9cial%3ARecherche&profile=default&fulltext=1&ns0=1");
        Intent naviguer = new Intent(Intent.ACTION_VIEW,chemin);
        startActivity(naviguer);
    }

    }
