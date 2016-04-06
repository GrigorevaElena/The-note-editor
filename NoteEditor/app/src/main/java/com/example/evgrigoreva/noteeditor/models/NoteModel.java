package com.example.evgrigoreva.noteeditor.models;

import android.os.Parcel;

import java.sql.Date;

/**
 * Created by Лена on 06.04.2016.
 */
public class NoteModel extends BaseModel {
    private String noteName;
    private String noteText;
    private String dateOfCreation;
    private String dateOfLastChanged;
    //TODO пусть пока будет имя
    private String authorName;

    public NoteModel(long pk, String authorName, long dateOfCreation) {
        super(pk);
        this.authorName = authorName;
        this.dateOfCreation = (new Date(dateOfCreation)).toString();
    }

    protected NoteModel(Parcel in) {
        super(in);
        noteName = in.readString();
        noteText = in.readString();
        authorName = in.readString();
        dateOfCreation = in.readString();
        dateOfLastChanged = in.readString();
    }

    public static final Creator<NoteModel> CREATOR = new Creator<NoteModel>() {
        @Override
        public NoteModel createFromParcel(Parcel in) {
            return new NoteModel(in);
        }

        @Override
        public NoteModel[] newArray(int size) {
            return new NoteModel[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(noteName);
        dest.writeString(noteText);
        dest.writeString(authorName);
        dest.writeString(dateOfCreation);
        dest.writeString(dateOfLastChanged);
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public Date getDateOfCreation() {
        return Date.valueOf(dateOfCreation);
    }
}
