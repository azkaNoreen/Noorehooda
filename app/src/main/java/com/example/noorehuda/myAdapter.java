package com.example.noorehuda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class myAdapter extends ArrayAdapter<PairString> {
    Button bt;
    Context base;
    public myAdapter(@NonNull Context context, ArrayList ob) {
        super(context, 0,ob);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PairString tdm = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.singlelist, parent, false);
        TextView vers = convertView.findViewById(R.id.verse);

        TextView tn = convertView.findViewById(R.id.eng);
        TextView td = convertView.findViewById(R.id.urdu);

        vers.setText(tdm.getVerse());
        tn.setText(tdm.geteTrans());
        td.setText(tdm.getUtrans());

        return convertView;

}
}
