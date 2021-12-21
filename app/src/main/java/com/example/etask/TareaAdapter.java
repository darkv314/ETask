package com.example.etask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class TareaAdapter extends BaseAdapter {

    Context context;
    List<modelTarea> tareas;

    public TareaAdapter(Context context, List<modelTarea> tareas){
        this.context=context;
        this.tareas=tareas;
    }

    @Override
    public int getCount() {
        return tareas.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout parentLinearLayout;
        TextView tituloTextView;
        TextView descripcionTextView;
        TextView fechaTextView;

        modelTarea t = tareas.get(i);
        if(view==null){
            view = LayoutInflater.from(context).inflate(R.layout.tarea_model_layout, null);
        }
        tituloTextView = view.findViewById(R.id.tareaTitulo);
        descripcionTextView = view.findViewById(R.id.tareadescripcion);
        fechaTextView = view.findViewById(R.id.tareaFecha);
        tituloTextView.setText(t.getTitulo());
        descripcionTextView.setText(t.getDescripcion());
        fechaTextView.setText(t.getFechai());
        return view;
    }

//    static  class ViewHolder{
//        LinearLayout parentLinearLayout;
//        TextView nameTextView;
//        TextView detailsTextView;
//        TextView fechaTextView;
//    }
}
