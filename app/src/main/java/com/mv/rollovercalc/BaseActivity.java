package com.mv.rollovercalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class BaseActivity extends AppCompatActivity {

    public static ArrayList<String> vehicleTypes;
    public static ArrayList<Vehicle> vehiclesList;
    public static String name = null;
    public static Vehicle selectedVehicle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareDefaultList();
        prepareSortNameList();
    }

    private void prepareDefaultList() {
        vehiclesList = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setType("Sports car");
        vehicle1.setMinht(15);
        vehicle1.setMaxht(20);
        vehicle1.setMinTrack(50);
        vehicle1.setMaxTrack(60);
        vehicle1.setMinRollThreshold(1.2);
        vehicle1.setMaxRollThreshold(1.7);
        vehiclesList.add(vehicle1);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setType("Compact car");
        vehicle2.setMinht(20);
        vehicle2.setMaxht(23);
        vehicle2.setMinTrack(50);
        vehicle2.setMaxTrack(60);
        vehicle2.setMinRollThreshold(1.1);
        vehicle2.setMaxRollThreshold(1.5);
        vehiclesList.add(vehicle2);

        Vehicle vehicle3 = new Vehicle();
        vehicle3.setType("Luxury car");
        vehicle3.setMinht(20);
        vehicle3.setMaxht(24);
        vehicle3.setMinTrack(60);
        vehicle3.setMaxTrack(65);
        vehicle3.setMinRollThreshold(1.2);
        vehicle3.setMaxRollThreshold(1.6);
        vehiclesList.add(vehicle3);

        Vehicle vehicle4 = new Vehicle();
        vehicle4.setType("Pick-up truck");
        vehicle4.setMinht(30);
        vehicle4.setMaxht(35);
        vehicle4.setMinTrack(65);
        vehicle4.setMaxTrack(70);
        vehicle4.setMinRollThreshold(0.9);
        vehicle4.setMaxRollThreshold(1.1);
        vehiclesList.add(vehicle4);

        Vehicle vehicle5 = new Vehicle();
        vehicle5.setType("Passenger van");
        vehicle5.setMinht(30);
        vehicle5.setMaxht(40);
        vehicle5.setMinTrack(65);
        vehicle5.setMaxTrack(70);
        vehicle5.setMinRollThreshold(0.9);
        vehicle5.setMaxRollThreshold(1.1);
        vehiclesList.add(vehicle5);

        Vehicle vehicle6 = new Vehicle();
        vehicle6.setType("Medium truck");
        vehicle6.setMinht(45);
        vehicle6.setMaxht(55);
        vehicle6.setMinTrack(65);
        vehicle6.setMaxTrack(75);
        vehicle6.setMinRollThreshold(0.6);
        vehicle6.setMaxRollThreshold(0.8);
        vehiclesList.add(vehicle6);

        Vehicle vehicle7 = new Vehicle();
        vehicle7.setType("Heavy truck");
        vehicle7.setMinht(60);
        vehicle7.setMaxht(85);
        vehicle7.setMinTrack(70);
        vehicle7.setMaxTrack(72);
        vehicle7.setMinRollThreshold(0.4);
        vehicle7.setMaxRollThreshold(0.6);
        vehiclesList.add(vehicle7);
    }

    private void prepareSortNameList() {
        vehicleTypes = new ArrayList<>();
        for (Vehicle vehicle : vehiclesList) {
            vehicleTypes.add(vehicle.getType());
        }
        Collections.sort(vehicleTypes);
        vehicleTypes.add("select");
        Collections.reverse(vehicleTypes);
    }
}
