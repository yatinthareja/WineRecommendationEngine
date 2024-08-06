package com.reservation.engine.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class AbstractBaseEntity<ID extends Serializable> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@CreatedBy @Column private String createdBy;

    @CreatedDate @Column(nullable = false, updatable = false) private LocalDateTime createdAt;

    @LastModifiedBy @Column private String modifiedBy;

    @LastModifiedDate @Column private LocalDateTime modifiedAt;
    
    public abstract ID getId();
    
    @PrePersist
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.modifiedAt = LocalDateTime.now();
	}

}
