package com.module.vitalSignModule.vitalSignModule.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;
import com.module.vitalSignModule.vitalSignModule.dto.VitalSignDto;
import com.module.vitalSignModule.vitalSignModule.dto.VitalSignKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * VitalSignEntity used as entity for VitalSign table.
 * @author Kowshik Bharathi M
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignEntity implements Serializable{

	private UUID patientId;
	private Date visitDate;
	private Integer temperatute;
	private Integer bloodPressure;
	private Integer sugerLevel;
	private String visitReason;
	private String lastUpdateUserId;
	private Date lastUpdateDateTime;
	
	public static VitalSignEntity formEntity(VitalSignDto vitalSignDto) {
		VitalSignEntity vitalSignEntity=new VitalSignEntity();
		vitalSignEntity.setPatientId(vitalSignDto.getId().getPatientId());
		vitalSignEntity.setVisitDate(vitalSignDto.getId().getVisitDate());
		vitalSignEntity.setTemperatute(vitalSignDto.getTemperatute());
		vitalSignEntity.setBloodPressure(vitalSignDto.getBloodPressure());
		vitalSignEntity.setSugerLevel(vitalSignDto.getSugerLevel());
		vitalSignEntity.setVisitReason(vitalSignDto.getVisitReason());
		vitalSignEntity.setLastUpdateUserId(vitalSignDto.getLastUpdateUserId());
		vitalSignEntity.setLastUpdateDateTime(vitalSignDto.getLastUpdateDateTime());
		return vitalSignEntity;
	}
	
	public static VitalSignDto formDto(VitalSignEntity vitalSignEntity) {
		VitalSignDto vitalSignDto=new VitalSignDto();
		VitalSignKey vitalSignKey=new VitalSignKey();
		vitalSignKey.setPatientId(vitalSignEntity.getPatientId());
		vitalSignKey.setVisitDate(vitalSignEntity.getVisitDate());
		vitalSignDto.setId(vitalSignKey);
		vitalSignDto.setTemperatute(vitalSignEntity.getTemperatute());
		vitalSignDto.setBloodPressure(vitalSignEntity.getBloodPressure());
		vitalSignDto.setSugerLevel(vitalSignEntity.getSugerLevel());
		vitalSignDto.setVisitReason(vitalSignEntity.getVisitReason());
		vitalSignDto.setLastUpdateUserId(vitalSignEntity.getLastUpdateUserId());
		vitalSignDto.setLastUpdateDateTime(vitalSignEntity.getLastUpdateDateTime());
		return vitalSignDto;
	}
	
}
