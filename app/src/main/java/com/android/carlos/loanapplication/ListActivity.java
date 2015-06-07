package com.android.carlos.loanapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ListActivity extends android.app.ListActivity {

    static ArrayList<Loan> loans = new ArrayList<>();
    Intent getLoans = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String[] values = new String[loans.size()];
        //cargar los loans
        for(int l=0; l < loans.size(); l++){
            values[l] = "Cliente: "+loans.get(l).nombreCliente +"Fecha de Creacion: "+ loans.get(l).fechaCreacion +"Balance: "+ loans.get(l).balance;
        }

        // use your custom layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.activity_list , R.id.label, values);
        setListAdapter(adapter);
    }

    public void onNewLoan(View v){
        Intent addNewLoan = new Intent(this, CrearPrestamoActivity.class);
        final int result = 1;
        startActivityForResult(addNewLoan, result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        loans.add(new Loan(data.getExtras().getInt("code"),data.getExtras().getString("name"),data.getExtras().getDouble("monto")));

    }
}
