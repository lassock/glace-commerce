package com.example.pratiquedelimdi23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

public class OrderActivity extends AppCompatActivity implements  AdapterView.OnItemSelectedListener {
EditText name;
EditText adresse;
EditText numero;
EditText description;
Button btn;
public static  final String p="presone";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        name = findViewById(R.id.name_text);
        adresse = findViewById(R.id.address_text);
        numero = findViewById(R.id.phone_text);
        description = findViewById(R.id.name_text);
        btn = findViewById(R.id.btn_enregistrement);
        Intent intent = getIntent();
        String message = "Order: " +
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.tv1);
        textView.setText(message);



        Spinner spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,

                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = name.getText().toString();
                String adres = adresse.getText().toString();
                String phone = numero.getText().toString();
                String descrip = description.getText().toString();
                Personne personne =new Personne(nom,adres,phone,descrip);

                if (personne.getNomproprisetaire().length()<=4){
                    name.setError("Nom trop cour");
                }else {
                    Intent intent = new Intent(OrderActivity.this,Confirmation.class);
                    intent.putExtra(p,personne);
                    startActivity(intent);


                }

            }
        });

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.pick_up));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}