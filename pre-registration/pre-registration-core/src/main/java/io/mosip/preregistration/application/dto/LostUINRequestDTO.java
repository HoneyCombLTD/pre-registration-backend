package io.mosip.preregistration.application.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * This DTO class defines the variables to accept the input parameter from
 * request.
 * 
 * @author Joel K
 * @since 1.2.0
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LostUINRequestDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 686366342082625076L;
	/**
	 * language code
	 */
	private String langCode;

	// pre pre registration ID
	private String preregistrationId;

}
