package com.tuanhung.lakesidehotel.response;

import org.hibernate.validator.internal.util.privilegedactions.LoadClass;

import java.time.LocalDate;

public class BookedRoomResponse {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestName;
    private String guestEmail;
    private int numOfAdults;
    private int numOfChildren;
    private String bookingConfirmationCode;
    private RoomResponse room;

    public BookedRoomResponse(Long id, LocalDate checkInDate, LocalDate checkOutDate, String bookingConfirmationCode) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
