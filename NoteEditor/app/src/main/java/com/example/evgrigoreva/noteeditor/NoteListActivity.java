package com.example.evgrigoreva.noteeditor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.evgrigoreva.noteeditor.adapters.NoteListAdapter;
import com.example.evgrigoreva.noteeditor.models.NoteModel;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Лена on 06.01.2016.
 */
public class NoteListActivity extends AppCompatActivity {
    private RecyclerView listView;
    private NoteListAdapter listAdapter;
    private ArrayList<NoteModel> noteList;

    private static String AUTHOR_NAME = "grigorevaev";
    public static String DATA_LIST = "data_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list_activity);

        if(savedInstanceState != null){
            noteList = savedInstanceState.getParcelableArrayList(DATA_LIST);
        } else {
            generateNoteList();
        }

        listView = (RecyclerView) findViewById(R.id.note_list_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this , RecyclerView.VERTICAL,false);
        listView.setLayoutManager(layoutManager);
        listView.setHasFixedSize(true);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setItemViewCacheSize(15);
        listAdapter = new NoteListAdapter();
        listAdapter.setNotes(noteList);
        listView.setAdapter(listAdapter);
    }


    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(DATA_LIST, listAdapter.getNoteList());
        super.onSaveInstanceState(savedInstanceState);
    }

    private NoteModel generateNoteModel(long pk, String noteText){
        Date d = new Date();
        NoteModel model = new NoteModel(pk, AUTHOR_NAME, d.getTime());
        model.setNoteText(noteText);
        return model;
    }

    private void generateNoteList(){
        noteList = new ArrayList<>();
        for(int i = 0; i < 38; i++) {
            noteList.add(generateNoteModel(i, "Текст заметки № " + i));
        }
    }
}
