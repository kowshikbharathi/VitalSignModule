package com.module.vitalSignModule.vitalSignModule.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.module.vitalSignModule.vitalSignModule.entity.VitalSignEntity;
import com.module.vitalSignModule.vitalSignModule.service.VitalSignService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.cache.annotation.Cacheable;
/**
 * VitalSignController which is used for VitalSign end point.
 * @author Kowshik Bharathi M
 */

@RestController
@Api(value = "VitalSign Service", description = "VitalSign Module")
@RequestMapping("/vitalSign")
public class VitalSignController {
	
	@Autowired
	public VitalSignController(VitalSignService vitalSignService) {
	    super();	
		this.vitalSignService=vitalSignService;
	}
	private final VitalSignService vitalSignService;
	
	/**
	 * registerVitalSign method is used to register VitalSign for each patients.
	 * @param vitalSignEntity
	 * @return Boolean
	 */
	@ApiOperation(value = "Register VitalSign API")
	@PostMapping("/register")
	public Boolean registerVitalSign(@RequestBody VitalSignEntity vitalSignEntity ) {
		return vitalSignService.save(vitalSignEntity);
	}
	
	/**
	 * getVitalSign method is used to retrieve vitalSign of a patients on each visit.
	 * @param userId
	 * @param visitDate
	 * @return VitalSignEntity
	 */
	@ApiOperation(value = "Get VitalSign API")
	@GetMapping("getVitalSign/{userId}/{visitDate}")
	@Cacheable(value="vital", key="{#userId,#visitDate}" )
	public VitalSignEntity getVitalSign(@PathVariable String userId,@PathVariable  Date visitDate ) {
		return vitalSignService.getByKeys(userId, visitDate);
	}

}
