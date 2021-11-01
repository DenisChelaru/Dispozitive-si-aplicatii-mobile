package com.example.reddit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TopicAdaptor extends BaseAdapter {

    private List<Topic> listaTopicuri=new ArrayList<>();

    public TopicAdaptor(List<Topic> lista) {

        listaTopicuri=lista;

    }

    @Override
    public int getCount() {
        return listaTopicuri.size();
    }

    @Override
    public Object getItem(int position) {
        return listaTopicuri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View itemView=inflater.inflate(R.layout.item_menu,parent,false);
        TextView t_nume=itemView.findViewById(R.id.topicNume);
        Topic current= listaTopicuri.get(position);
        t_nume.setText(current.getNumeTopic());
        return itemView;
    }

    public void updateList(List<Topic> lista_noua)
    {
        this.listaTopicuri.clear();
        this.listaTopicuri.addAll(lista_noua);
        notifyDataSetChanged();

    }
}
