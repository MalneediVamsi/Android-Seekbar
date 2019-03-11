package com.mv.rollovercalc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.SeekBar;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckingActivity extends BaseActivity {

    private SeekBar htSeekbar;
    private SeekBar trackSeekbar;
    private TextView calThreshold;
    private TextView result;
    private TextView htValueTv;
    private TextView trackValueTv;

    private double htValue = selectedVehicle.getMinht();
    private double trackValue = selectedVehicle.getMinTrack();
    private double thresholdValue;
    //int value = (seekBar.getProgress() * (max - min)) + min;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checking);
        initializeViews();
        htValueTv.setText("Height (inches)     " + htValue);
        trackValueTv.setText("Track (inches)     " + trackValue);

        htSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                htValue = (((selectedVehicle.getMaxht() - selectedVehicle.getMinht()) * progress) / (double) 100) + selectedVehicle.getMinht();
                htValue = BigDecimal.valueOf(htValue)
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();
                calculateThresholdValue(htValue, trackValue);
                htValueTv.setText("Height (inches)     " + htValue);
                calThreshold.setText(getResources().getString(R.string.calThreshold) + "   " + thresholdValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        trackSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                trackValue = ((progress * (selectedVehicle.getMaxTrack() - selectedVehicle.getMinTrack()) / (double) 100) + selectedVehicle.getMinTrack());
                trackValue = BigDecimal.valueOf(trackValue)
                        .setScale(2, RoundingMode.HALF_UP)
                        .doubleValue();
                calculateThresholdValue(htValue, trackValue);
                trackValueTv.setText("Track (inches)     " + trackValue);
                calThreshold.setText(getResources().getString(R.string.calThreshold) + "   " + thresholdValue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initializeViews() {
        htSeekbar = findViewById(R.id.ht_sb);
        trackSeekbar = findViewById(R.id.trck_sb);
        TextView minThreshold = findViewById(R.id.minThr_tv);
        TextView maxThreshold = findViewById(R.id.maxThr_tv);
        calThreshold = findViewById(R.id.calThr_tv);
        result = findViewById(R.id.result);
        htValueTv = findViewById(R.id.htValue_tv);
        trackValueTv = findViewById(R.id.trackValue_tv);
        TextView vehicle = findViewById(R.id.vehicle_tv);

        vehicle.setText(selectedVehicle.getType());
        minThreshold.setText(getResources().getString(R.string.minThreshold) + "                          " + selectedVehicle.getMinRollThreshold());
        maxThreshold.setText(getResources().getString(R.string.maxThreshold) + "                          " + selectedVehicle.getMaxRollThreshold());
    }

    public void calculateThresholdValue(double htValue, double trackValue) {
        thresholdValue = trackValue / (2 * htValue);
        thresholdValue = BigDecimal.valueOf(thresholdValue)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        if (thresholdValue > selectedVehicle.getMaxRollThreshold() || thresholdValue < selectedVehicle.getMinRollThreshold()) {
            result.setText("UNSTABLE");
            result.setTextColor(getResources().getColor(android.R.color.holo_red_light));
        } else {
            result.setText("STABLE");
            result.setTextColor(getResources().getColor(android.R.color.holo_green_light));
        }
    }
}
