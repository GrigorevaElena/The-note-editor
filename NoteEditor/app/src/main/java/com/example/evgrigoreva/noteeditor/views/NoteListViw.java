package com.example.evgrigoreva.noteeditor.views;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;


/**
 * Created by Лена on 31.01.2016.
 */
public class NoteListViw extends RecyclerView {

    public NoteListViw(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public NoteListViw(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public NoteListViw(Context context) {
        super(context);
        init();
    }

    private void init(){
        setHasFixedSize(true);
        LayoutManager layoutManager = new LinearLayoutManager(getContext(),VERTICAL,false);
        setLayoutManager(layoutManager);
        setItemAnimator(new DefaultItemAnimator());
    }
}
