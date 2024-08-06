package com.reservation.engine.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.reservation.engine.enums.Salutation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
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
@Table(name = "guest", indexes = {@Index(name = "guest_uuid_idx", columnList = "uuid")})
public class Guest extends AbstractBaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "salutation")
	@Enumerated(EnumType.STRING)
	private Salutation salutation;
	
	@Column(name = "first_name", nullable = false, length = 255)
	private String firstName;
	
	@Column(name = "last_name", nullable = false, length = 255)
	private String lastName;
	
	@Column(name = "email_address", nullable = false, length = 320)
	private String emailAddress;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Column(name = "phone_number_verified")
	private boolean phoneNumberVerified;
	
}
