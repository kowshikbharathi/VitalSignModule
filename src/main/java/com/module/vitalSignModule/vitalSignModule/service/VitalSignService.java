package com.module.vitalSignModule.vitalSignModule.service;

import java.sql.Date;

import com.module.vitalSignModule.vitalSignModule.entity.VitalSignEntity;

/**
 * VitalSignService is used for VitalSign CRUD.
 * @author Kowshik Bharathi M
 */
public interface VitalSignService {
	
	/**
	 * save method is used to save vitalSign.
	 * @param vitalSignEntity
	 * @return Boolean
	 */
	public Boolean save(VitalSignEntity vitalSignEntity);

	/**
	 * getByKeys method is used get vitalSign.
	 * @param userId
	 * @param visitDate
	 * @return VitalSignEntity
	 */
	public VitalSignEntity getByKeys(String userId, Date visitDate);
}
