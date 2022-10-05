# pre-registration-application-service

This service manages to provide the following service to the Pre-registration application.

  * Demographic - This service details used by Pre-Registration portal to maintain the demographic data by providing his/her basic details.
  * Document- This service enables Pre-Registration portal to request for uploading the document for a particular pre-registration.
  * QrCodeGenerator- This service details used by Pre-Registration portal to generate QR Code.
  * Transliteration- This service details used by Pre-Registration portal to provide transliteration from one language to another language.
  * Notification- This service details used by Pre-Registration portal to trigger notification via SMS or email.
  * Login - This service details used by Pre-Registration portal to authenticate user by sending OTP to the user, validating  with userid and OTP. 

## Default Port and Context Path

  * server.port=9092
  * server.servlet.context-path=/preregistration/v1

## Swagger URL
* https://{dns-name}:9092/preregistration/v1/application-service/swagger-ui.html

## Roles to Access the URL

* INDIVIDUAL
* REGISTRATION_OFFICER
* REGISTRATION_SUPERVISOR
* REGISTRATION_ADMIN

## API Dependencies
	
* kernel-auditmanager-service

* kernel-syncdata-service

* kernel-otpmanager-service

* kernel-notification-service

* kernel-masterdata-service

* kernel-keymanager-service

* kernel-pridgenerator-service

* kernel-auth-service

* keycloak

## Technology Associates Fixes

* Comment out to disable otp generation and sending email in the `OTPManager.java`.
```
String otp = generateOTP(requestDTO);

notification.invokeEmailNotification(mp, userId, requestDTO, language);
```

* Comment out these lines in the `DemographicServiceUtil.java` file as suggested by the mosip team
```
throw new SystemFileIOException(DemographicErrorCodes.PRG_PAM_APP_018.getCode(),

DemographicErrorMessages.UBALE_TO_READ_IDENTITY_JSON.getMessage(), null);
```

* Add config server specification in the properties files eg. shown below is our case
```
spring.cloud.config.uri=http://localhost:8878
spring.cloud.config.label=1.2.0.1-v3
spring.cloud.config.name=pre-registration-default
spring.profiles.active=default
```

* Make extra necessary configuration eg 
  * DB connection details
  * Mapping the internal services to their respective proxies
