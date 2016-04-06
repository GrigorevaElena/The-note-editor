package com.example.evgrigoreva.noteeditor.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Лена on 31.01.2016.
 */
public class BaseModel implements Comparable, Parcelable {
    protected long pk;

    public BaseModel(long pk){
        this.pk = pk;
    }

    protected BaseModel(Parcel in) {
        pk = in.readLong();
    }

    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(int size) {
            return new BaseModel[size];
        }
    };

    @Override
    public int compareTo(@NonNull Object another) {
        if(another instanceof BaseModel){
            return pk == ((BaseModel) another).getPk() ? 1 : 0;
        }
        return 0;
    }

    public long getPk(){
        return pk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(pk);
    }
}
