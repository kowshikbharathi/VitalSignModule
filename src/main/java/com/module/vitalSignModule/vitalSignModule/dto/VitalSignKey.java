package com.module.vitalSignModule.vitalSignModule.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Type;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * VitalSignKey represent keys for vital sign table.
 * @author Kowshik Bharathi M
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignKey implements Serializable  {

	@Column(name="patient_id")
	@Type(type="uuid-char")
	private UUID patientId;
	@Column(name="visit_date")
	private Date visitDate;
}
