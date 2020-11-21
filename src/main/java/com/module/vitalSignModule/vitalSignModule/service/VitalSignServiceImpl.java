package com.module.vitalSignModule.vitalSignModule.service;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.module.vitalSignModule.vitalSignModule.client.PatientClient;
import com.module.vitalSignModule.vitalSignModule.dto.VitalSignDto;
import com.module.vitalSignModule.vitalSignModule.dto.VitalSignKey;
import com.module.vitalSignModule.vitalSignModule.entity.PatientEntity;
import com.module.vitalSignModule.vitalSignModule.entity.VitalSignEntity;
import com.module.vitalSignModule.vitalSignModule.repository.VitalSignRepository;

/**
 * VitalSignService which implement VitalSignService.
 * @author Kowshik Bharathi M
 */
@Service
public class VitalSignServiceImpl implements VitalSignService{

	@Autowired
	public VitalSignServiceImpl(VitalSignRepository vitalSignRepository,PatientClient patientClient) {
	    super();	
		this.vitalSignRepository=vitalSignRepository;
		this.patientClient=patientClient;
	}
	private final VitalSignRepository vitalSignRepository;
	private final PatientClient patientClient;
	
	@Override
	public Boolean save(VitalSignEntity vitalSignEntity) {
		vitalSignRepository.save(VitalSignEntity.formDto(vitalSignEntity));
		PatientEntity patientEntity=new PatientEntity();
		patientEntity.setPatientId(vitalSignEntity.getPatientId());
		patientEntity.setLastVisitDate(vitalSignEntity.getVisitDate());
		PatientEntity patientEntityResponse =patientClient.updateVistDate(patientEntity);
		if(Objects.nonNull(patientEntityResponse)){
			return true;
		}
		return false;
	}

	@Override
	public VitalSignEntity getByKeys(String userId, Date visitDate) {
		VitalSignKey vitalSignKey=new VitalSignKey();
		vitalSignKey.setPatientId(UUID.fromString(userId));
		vitalSignKey.setVisitDate(visitDate);
		Optional<VitalSignDto> optionalDto= vitalSignRepository.findById(vitalSignKey);
		if(optionalDto.isPresent()) {
			return VitalSignEntity.formEntity(optionalDto.get());
		}
		return null;
	}
}
