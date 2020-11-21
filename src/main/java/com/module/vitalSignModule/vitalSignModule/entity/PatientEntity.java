package com.module.vitalSignModule.vitalSignModule.entity;


import java.sql.Date;
import java.util.UUID;


import lombok.Data;

/**
 * PatientEntity used as entity for patient table.
 * @author Kowshik Bharathi M
 */
@Data
public class PatientEntity {

	private UUID patientId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String address;
	private Long contactNumber;
	private String emailId;
	private String consultDoctor;
	private Date lastVisitDate;
}
