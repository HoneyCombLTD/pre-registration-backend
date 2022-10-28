package io.mosip.preregistration.application.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.mosip.kernel.core.dataaccess.spi.repository.BaseRepository;
import io.mosip.preregistration.core.common.entity.LostUINEntity;

/**
 *
 * This repository interface is used to define the JPA methods for
 * LostUINRepository
 *
 * @author Joel K
 * @since 1.0.0
 *
 */
@Repository
@Transactional
public interface LostUINRepository extends BaseRepository<LostUINEntity, String> {

	@Query("SELECT e FROM LostUINEntity e  WHERE e.crBy= ?1 order by e.crDtime desc")
	public List<LostUINEntity> findByCreatedBy(String userId);

	@Query("SELECT e.demographicId FROM LostUINEntity e  WHERE e.applicationId= ?1 ")
	public String findDemographicsIdByAppId(String appId);

	@Modifying
	@Query("DELETE FROM ApplicationEntity e WHERE e.applicationId = ?1")
	public void deleteById(int applicationId);

	@Modifying
	@Query(value = "INSERT INTO application_replacements (replacement_id, demographic_id, application_id, lang_code, created_by) VALUES (?, ?, ?, ?, ?)", nativeQuery = true)
	LostUINEntity save(Integer replacementId, String demographicId, String applicationId, String langCode,
			String userId);
}
