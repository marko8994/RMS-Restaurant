package com.rms.markomladenovic.restoran;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    private String food;
    private String drink;
    private String comment;
    private String deliveryType;

    public Order() {}

    protected Order(Parcel in) {
        food = in.readString();
        drink = in.readString();
        comment = in.readString();
        deliveryType = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(food);
        dest.writeString(drink);
        dest.writeString(comment);
        dest.writeString(deliveryType);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }
}
