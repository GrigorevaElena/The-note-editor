package com.example.evgrigoreva.noteeditor.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.evgrigoreva.noteeditor.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Лена on 07.01.2016.
 */
public class NoteListAdapter extends RecyclerView.Adapter{
    List<Integer> notes;

    public NoteListAdapter() {
        notes = new ArrayList<>();
    }

    @Override
    public NoteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);
        return new NoteListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NoteListViewHolder)holder).noteBody.setText("Note body");
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteListViewHolder extends RecyclerView.ViewHolder {
        public TextView noteBody;

        public NoteListViewHolder(View itemView) {
            super(itemView);
            noteBody = (TextView)itemView.findViewById(R.id.textNote);
        }
    }

    public void setNotes(List<Integer> newNotes){
        if(newNotes != null){
            notes.clear();
            notes.addAll(newNotes);
            notifyDataSetChanged();
        }
    }

    public void addNotes(List<Integer> additionNotes){
        if(additionNotes != null){
            notes.addAll(additionNotes);
            notifyDataSetChanged();
        }
    }
}
