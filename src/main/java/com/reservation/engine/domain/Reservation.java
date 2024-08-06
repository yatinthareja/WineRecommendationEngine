package com.reservation.engine.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.reservation.engine.enums.ReservationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "reservation", indexes = {@Index(name = "reservation_uuid_idx", columnList = "uuid")})
public class Reservation extends AbstractBaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name= "user_id", nullable = true)
	private User userId;
	
	@ManyToOne
    @JoinColumn(name= "guest_id", nullable = true)
	private Guest guestId;
	
	@Column(name = "message")
	private String message;
	
	@Column(name="promotion_code", length = 20)
	private String promotionCode;
	
	@ManyToOne
    @JoinColumn(name= "restaurant_id", nullable = false)
	private Restaurant restaurantId;
	
	@ManyToOne
    @JoinColumn(name= "table_id")
	private TableEntity tableId;
	
	@Column(name = "reservation_date", nullable = false, insertable = true)
	private LocalDate reservationDate;
	
	@Column(name = "reservation_time", nullable = false, insertable = true)
	private LocalTime reservationTime;
	
	@Column(name = "number_of_guest", nullable = false, insertable = true)
	private int numberOfGuest;
	
	@Column(name = "status", nullable = false, insertable = true)
	@Enumerated(EnumType.STRING)
	private ReservationStatus status;

}
