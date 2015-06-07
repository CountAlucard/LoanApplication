package com.android.carlos.loanapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.ArrayList;


public class CrearPrestamoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_prestamo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crear_prestamo, menu);
        return true;
    }

    public void onCreateLoan(View v){
        EditText loanCode = (EditText) findViewById(R.id.etCodigo);
        EditText clientName = (EditText) findViewById(R.id.etCliente);
        EditText loanAmount = (EditText) findViewById(R.id.etMonto);

        int code = Integer.parseInt(String.valueOf(loanCode.getText()));
        String name = String.valueOf(clientName.getText());
        double monto = Double.parseDouble(String.valueOf(loanAmount.getText()));

        Intent goingBack = new Intent(this, ListActivity.class);
        goingBack.putExtra("code",code);
        goingBack.putExtra("name",name);
        goingBack.putExtra("monto",monto);

        setResult(RESULT_OK, goingBack);

        finish();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
