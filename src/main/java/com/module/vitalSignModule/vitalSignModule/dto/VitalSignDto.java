package com.module.vitalSignModule.vitalSignModule.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

/**
 * VitalSignDto represent vital sign table.
 * @author Kowshik Bharathi M
 */
@Entity
@Data
@Table(name="vital_sign_tb")
public class VitalSignDto implements Serializable{

	@EmbeddedId
	private VitalSignKey id;
	@Column(name="temperatute")
	private Integer temperatute;
	@Column(name="blood_pressure")
	private Integer bloodPressure;
	@Column(name="suger_level")
	private Integer sugerLevel;
	@Column(name="visit_reason")
	private String visitReason;
	@Column(name="last_update_user_id")
	private String lastUpdateUserId;
	@Column(name="last_update_date_time")
	private Date lastUpdateDateTime;
}
