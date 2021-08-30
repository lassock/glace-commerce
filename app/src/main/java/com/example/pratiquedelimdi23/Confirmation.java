package com.example.pratiquedelimdi23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Confirmation extends AppCompatActivity {
    TextView enre1;
    TextView enre2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        enre1 = findViewById(R.id.tv_name);
        enre2 = findViewById(R.id.tv2);

        Intent intent = getIntent();
        if (intent !=null){
            Personne personne = intent.getParcelableExtra(OrderActivity.p);
            if (personne!=null){
                enre1.setText((personne.getNomproprisetaire()+"--"+personne.getLieuproprisetaire()).toString());

                enre2.setText((personne.getPhoneproprisetaire()+"--"+personne.getDescriptionproprisetaire()).toString());

            }


        }
    }
}