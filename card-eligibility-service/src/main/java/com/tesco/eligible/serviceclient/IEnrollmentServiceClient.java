package com.tesco.eligible.serviceclient;

import com.tesco.eligible.model.EnrollmentRequest;
import com.tesco.eligible.model.EnrollmentResponse;

public interface IEnrollmentServiceClient {
	
	EnrollmentResponse enrollment(EnrollmentRequest enrollmentRequest);

}
