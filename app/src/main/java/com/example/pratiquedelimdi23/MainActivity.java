package com.example.pratiquedelimdi23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String mOrderMessage;
    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafe.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
    }
    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);

    }
    public void showFroyoOrder(View view) {

        displayToast(getString(R.string.froyo_order_message));
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
    }
    public  void showbuger(View view){
        displayToast("you order a buger");
        mOrderMessage="you order a buger";
        displayToast(mOrderMessage);
    }
    public  void showgateau(View view){
        displayToast("you order a gateau");
        mOrderMessage="you order a gateau";
        displayToast(mOrderMessage);
    }

    public void onClick(View view) {
        Intent intent =
                new Intent(MainActivity.this, OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }

}