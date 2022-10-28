/* 
 * Copyright
 * 
 */
package io.mosip.preregistration.core.common.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

/**
 * This entity class defines the database table details for LostUINEntity.
 *
 * @author Joel K
 * @since 1.0.0
 *
 */
@Component
@Entity
@Table(name = "application_replacements", schema = "prereg")
@NoArgsConstructor
@NamedQuery(name = "LostUINEntity.findByCreatedByOrderByCreateDateTime", query = "SELECT e FROM LostUINEntity e  WHERE e.crBy=:userId order by e.crDtime desc")
@NamedQuery(name = "LostUINEntity.findByCreatedBy", query = "SELECT e FROM LostUINEntity e  WHERE e.crBy=:userId order by e.crDtime desc")
public class LostUINEntity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6705845720255847210L;

	@Id
	@Column(name = "application_id")
	private String applicationId;

	@Column(name = "demographic_id", nullable = false)
	private String demographicId;

	@Column(name = "lang_code", nullable = false)
	private String langCode;

	@Column(name = "created_by")
	private String crBy;

	@Column(name = "created_at")
	private LocalDateTime crDtime;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setDemographicId(String demographicId) {
		this.demographicId = demographicId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public void setCrBy(String crBy) {
		this.crBy = crBy;
	}

	public void setCrDtime(LocalDateTime crDtime) {
		this.crDtime = crDtime;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
}
