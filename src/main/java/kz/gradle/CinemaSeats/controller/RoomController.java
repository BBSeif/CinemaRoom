package kz.gradle.CinemaSeats.controller;



import kz.gradle.CinemaSeats.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class RoomController {
    ShowRoom showRoom = new ShowRoom(9, 9);
    HashMap<UUID, Room> booked = new HashMap<>();


    @GetMapping("/seats")
    public ShowRoom returnShowRoom() {
        return  showRoom;
    }

    @PostMapping("/purchase/{row}/{column}")
    public ResponseEntity<Object> purchaseSeat(@PathVariable int row, @PathVariable int column) {
        if(row > showRoom.getTotal_rows() || column > showRoom.getTotal_columns()){
            return   new ResponseEntity<>(Map.of("error","The number of a row or a column is out of bounds!"), HttpStatus.BAD_REQUEST);
        }
        for(Room room : showRoom.getAvailable_seats()){
            if( room.getRow() == row && room.getColumn() == column && room.isEmpty() ) {
                room.setEmpty();
                UUID uuid = UUID.randomUUID();
                booked.put(uuid, room);
                return new ResponseEntity<>(Map.of("Token", uuid, "Ticket", room), HttpStatus.OK);
            }
        }
        return   new ResponseEntity<>(Map.of("error","The ticket has been already purchased!"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/return/{token}")
    public ResponseEntity<?> returnTicket (@PathVariable String token) {
        UUID uuid = UUID.fromString(token);
        Room room = booked.get(uuid);
        if (room == null) {
            return new ResponseEntity<>(Map.of( "error", "Wrong token!"), HttpStatus.BAD_REQUEST);
        } else {
            booked.remove(uuid);
            room.setNotEmpty();
            return new ResponseEntity<>(Map.of("returned_ticket", room), HttpStatus.OK);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(@RequestParam(required = false) String password) {
        if(password != null && password.equals("super_secret")) {
            int currentIncome = 0;
            int countPurchasedSeats = 0;
            int countAvailableSeats = 0;
            for (Room room : showRoom.getPurchased_seats()) {
                currentIncome = currentIncome + room.getPrice();
                countPurchasedSeats ++;
            }
            for (Room room : showRoom.getAvailable_seats()) {
                countAvailableSeats ++;
            }
            return new ResponseEntity<>(Map.of("current_income", currentIncome,
                    "number_of_available_seats", countAvailableSeats,
                    "number_of_purchased_tickets", countPurchasedSeats), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }
    }
}
