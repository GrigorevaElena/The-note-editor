package com.example.evgrigoreva.noteeditor.adapters;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.evgrigoreva.noteeditor.R;
import com.example.evgrigoreva.noteeditor.models.NoteModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Лена on 07.01.2016.
 */
public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteListViewHolder>{
    ArrayList<NoteModel> notes;

    public NoteListAdapter() {
        notes = new ArrayList<>();
        //setHasStableIds(true);
    }

    @Override
    public NoteListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);
        return new NoteListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final NoteListViewHolder holder, final int position) {
        holder.noteBody.setText(notes.get(position).getNoteText());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public ArrayList<NoteModel> getNoteList() {
        return notes;
    }

    public class NoteListViewHolder extends RecyclerView.ViewHolder {
        public TextView noteBody;
        public Button changeNote;
        public Button deleteNote;

        public NoteListViewHolder(View itemView) {
            super(itemView);
            noteBody = (TextView)itemView.findViewById(R.id.text_note);
            changeNote = (Button) itemView.findViewById(R.id.change_note);
            deleteNote = (Button) itemView.findViewById(R.id.delete_note);

            deleteNote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notes.remove(getPosition());
                    notifyItemRemoved(getPosition());
                }
            });
        }
    }

    public void setNotes(List<NoteModel> newNotes){
        if(newNotes != null){
            notes.clear();
            notes.addAll(newNotes);
            notifyDataSetChanged();
        }
    }

    public void addNotes(List<NoteModel> additionNotes){
        if(additionNotes != null){
            notes.addAll(additionNotes);
            notifyDataSetChanged();
        }
    }
}
