package kz.gradle.CinemaSeats.entity;


import java.util.ArrayList;
import java.util.List;

public class ShowRoom {
    private int total_rows;
    private int total_columns;
    private List<Room> available_seats;

    public ShowRoom(int total_rows, int total_columns) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = seatGenerator();
    }

    public List<Room> seatGenerator() {
        List<Room> seats = new ArrayList<>();
        for (int i = 1; i <= total_rows; i++) {
            int price;
            for (int j = 1; j <= total_columns; j++) {
                if (i <= 4) {
                    price = 10;
                } else {
                    price = 8;
                }
                seats.add(new Room(i, j, price));
            }
        }
        return seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Room> getAvailable_seats() {
        List<Room> available = new ArrayList<>();
        for(Room room : available_seats) {
            if (room.isEmpty() == true) {
                available.add(room);
            }
        }
        return available;
    }

    public List<Room> getPurchased_seats() {
        List<Room> puchased = new ArrayList<>();
        for(Room room : available_seats) {
            if (room.isEmpty() == false) {
                puchased.add(room);
            }
        }
        return puchased;
    }
}
