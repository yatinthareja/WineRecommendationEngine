package com.reservation.engine.domain;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@Table(name = "restaurant", indexes = {@Index(name = "restaurant_uuid_idx", columnList = "uuid")})
public class Restaurant extends AbstractBaseEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name", length = 255)
	private String name;
	
	@Column(name = "description", length = 255)
	private String description;
	
	@Column(name = "address", length = 255)
	private String address;
	
	@Column(name = "phone_number", length = 20)
	private String phoneNumber;
	
	@Column(name = "email", length = 320)
	private String email;

}
