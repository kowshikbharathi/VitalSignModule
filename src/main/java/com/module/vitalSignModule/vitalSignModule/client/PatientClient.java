package com.module.vitalSignModule.vitalSignModule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.module.vitalSignModule.vitalSignModule.entity.PatientEntity;

/**
 * PatientClient is act as patient endpoint client
 * @author Kowshik Bharathi M
 */
@FeignClient(url="${healthcare.management.patient.uri}" ,name="${healthcare.management.patient.name}")
public interface PatientClient {

	@PostMapping("/updateVisitDate")
	public PatientEntity updateVistDate(@RequestBody PatientEntity patientEnity) ;
}
