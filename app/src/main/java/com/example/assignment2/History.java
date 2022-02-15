package com.example.assignment2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class History implements Parcelable {
    private String h_name;
    private int h_qty;
    private float h_total;
    private Date h_date;

    public History(){}

    protected History(Parcel in) {
        h_name = in.readString();
        h_qty = in.readInt();
        h_total = in.readFloat();
        h_date = (Date)in.readSerializable();
    }

    // Getters and Setters
    public void setName(String name) { this.h_name = name; }
    public void setQty(int qty) { this.h_qty = qty; }
    public void setTotal(float total) { this.h_total = total; }
    public void setDate(Date date) { this.h_date = date; }

    public String getName() { return this.h_name; }
    public int getQty() { return this.h_qty; }
    public float getTotal() { return this.h_total; }
    public Date getDate() { return this.h_date; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(h_name);
        parcel.writeInt(h_qty);
        parcel.writeFloat(h_total);
        parcel.writeSerializable(h_date);
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

}
