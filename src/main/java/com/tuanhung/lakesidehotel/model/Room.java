package com.tuanhung.lakesidehotel.model;

import ch.qos.logback.core.testUtil.RandomUtil;
import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal roomPrice;
    private String roomType;
    @Lob
    public Blob photo;
    private boolean isBooked = false;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;
    public Room() {
        this.bookings = new ArrayList<>();
    }
    public void addNewBooking(BookedRoom booking) {
        if(bookings == null) {
            bookings = new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked = true;
        String bookingCode = RandomStringUtils.randomNumeric(10);
        booking.setBookingConfirmationCode(bookingCode);
    }
}
