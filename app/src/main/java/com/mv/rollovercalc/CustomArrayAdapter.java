package com.mv.rollovercalc;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomArrayAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<String> items;
    private final int layout;

    public CustomArrayAdapter(@NonNull Context context, @LayoutRes int layout,
                              @NonNull List objects) {
        super(context, layout, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.layout = layout;
        items = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(layout, parent, false);

        switch (layout) {
            case R.layout.simple_spinner_item:
                TextView spinnerItem = (TextView) view.findViewById(R.id.spinnerItem);
                String item = items.get(position);
                spinnerItem.setText(item);
                break;

            default:
                break;
        }
        return view;
    }
}
