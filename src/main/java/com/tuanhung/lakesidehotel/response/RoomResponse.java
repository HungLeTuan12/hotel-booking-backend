package com.tuanhung.lakesidehotel.response;

import com.tuanhung.lakesidehotel.model.BookedRoom;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;
@Data
public class RoomResponse {
    private Long id;
    private BigDecimal roomPrice;
    private String roomType;
    public String photo;
    private boolean isBooked;
    private List<BookedRoomResponse> bookings;

    public RoomResponse(Long id, BigDecimal roomPrice, String roomType) {
        this.id = id;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    public RoomResponse(Long id, BigDecimal roomPrice, String roomType, byte[] photoBytes, boolean isBooked, List<BookedRoomResponse> bookings) {
        this.id = id;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
        this.isBooked = isBooked;
        this.bookings = bookings;
    }
}
