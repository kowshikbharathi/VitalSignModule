 package com.module.vitalSignModule.vitalSignModule.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import  com.module.vitalSignModule.vitalSignModule.dto.VitalSignKey;
import com.module.vitalSignModule.vitalSignModule.dto.VitalSignDto;


/**
 * RoleRepository repository for Role table.
 * @author Kowshik Bharathi M
 */
@Repository
public interface VitalSignRepository extends JpaRepository<VitalSignDto, VitalSignKey>, JpaSpecificationExecutor<VitalSignDto>{

}
