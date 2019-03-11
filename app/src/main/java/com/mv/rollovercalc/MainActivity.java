package com.mv.rollovercalc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener {

    private CustomArrayAdapter dataAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        Button button = findViewById(R.id.proceed_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.contains("select")) {
                    getSelectedVehicle();
                    Intent intent = new Intent(context, CheckingActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "Please select vehicle type", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dataAdapter = new CustomArrayAdapter(this, R.layout.simple_spinner_item, vehicleTypes);

        Spinner spinner = findViewById(R.id.type_sp);
        spinner.setOnItemSelectedListener(this);
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    private void getSelectedVehicle() {
        for(Vehicle vehicle:vehiclesList){
            if(vehicle.getType().equals(name)){
                selectedVehicle = vehicle;
            }
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        name = parent.getItemAtPosition(position).toString().trim();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
