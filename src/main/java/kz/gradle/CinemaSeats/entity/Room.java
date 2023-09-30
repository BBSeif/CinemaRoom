package kz.gradle.CinemaSeats.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Room {
    private final int row;
    private final int column;
    private final int price;

    @JsonIgnore
    private boolean empty;


    public Room(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
//        By default, seat is empty
        this.empty = true;
    }

    public void setEmpty() {
//        When we set it becomes not empty
        this.empty = false;
    }
    public void setNotEmpty() {
        this.empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "{" +
                "row :" + row +
                ", column :" + column +
                ", price :" + price +
                '}';
    }
}
