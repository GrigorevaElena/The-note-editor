package com.example.evgrigoreva.noteeditor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.evgrigoreva.noteeditor.adapters.NoteListAdapter;
import com.example.evgrigoreva.noteeditor.views.NoteListViw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Лена on 06.01.2016.
 */
public class NoteListActivity extends AppCompatActivity {
    private NoteListViw listView;
    private NoteListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_list_activity);

        List<Integer> noteList = new ArrayList<>();
        noteList.add(1);
        noteList.add(2);
        noteList.add(3);

        listView = (NoteListViw) findViewById(R.id.note_list_view);
        listAdapter = new NoteListAdapter();
        listAdapter.setNotes(noteList);
        listView.setAdapter(listAdapter);

    }
}
