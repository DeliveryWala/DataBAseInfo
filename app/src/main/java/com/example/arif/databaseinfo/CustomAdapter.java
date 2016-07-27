package com.example.arif.databaseinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arif on 27/07/16.
 */
public class CustomAdapter extends ArrayAdapter<Data> {
    private List<Data> objects;
    public CustomAdapter(Context context, int resourceId, List<Data> objects) {
        super(context, resourceId,objects);
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if(v==null)
        {
            LayoutInflater inflater= (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.list_view,null);
        }
        Data data=objects.get(position);
        if(data!=null)
        {
            TextView fname= (TextView) v.findViewById(R.id.textView4);
            TextView f= (TextView) v.findViewById(R.id.textView5);
            TextView lname= (TextView) v.findViewById(R.id.textView6);
            TextView l= (TextView) v.findViewById(R.id.textView7);
            TextView batch= (TextView) v.findViewById(R.id.textView8);
            TextView b= (TextView) v.findViewById(R.id.textView9);

        if(fname!=null)
        {
            fname.setText("First Name:");
        }
            if(f!=null)
            {
                l.setText(data.getfName());
            }

            if(lname!=null)
            {
                fname.setText("Last Name:");
            }
            if(l!=null)
            {
                l.setText(data.getlName());
            }

            if(batch!=null)
            {
                batch.setText("Batch:");
            }
            if(b!=null)
            {
                b.setText(data.getBatch());
            }
    }
        return v;
}}
