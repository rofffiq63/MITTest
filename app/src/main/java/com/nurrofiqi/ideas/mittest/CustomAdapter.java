package com.nurrofiqi.ideas.mittest;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> chars;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, ArrayList<String> character) {
        this.context = applicationContext;
        this.chars = character;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return chars.size();
    }

    @Override
    public Object getItem(int position) {
        return chars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_list, null);
        TextView textView = view.findViewById(R.id.textview);
        textView.setText(Html.fromHtml("<b>"+chars.get(position)+"</b>"+ "<br>p" + position));
        return view;
    }
}
