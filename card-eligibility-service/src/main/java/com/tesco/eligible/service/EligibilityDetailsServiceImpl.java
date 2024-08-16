package com.tesco.eligible.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.eligible.builder.EligibilityDetailsRequestBuilder;
import com.tesco.eligible.builder.EligibilityDetailsRespBuilder;
import com.tesco.eligible.dao.IEligibilityDetailsDao;
import com.tesco.eligible.model.EnrollmentRequest;
import com.tesco.eligible.model.EnrollmentResponse;
import com.tesco.eligible.model.OfferDetailsDaoRequest;
import com.tesco.eligible.model.OfferDetailsDaoResp;
import com.tesco.eligible.model.OfferDetailsRequest;
import com.tesco.eligible.model.OfferDetailsResponse;
import com.tesco.eligible.serviceclient.IEnrollmentServiceClient;





@Component
public class EligibilityDetailsServiceImpl implements IEligibilityDetailsService{
	
	@Autowired
	EligibilityDetailsRequestBuilder offerDtlsReqBuilder;
	
	@Autowired
	EligibilityDetailsRespBuilder offerDtlsResBuilder;
	
	@Autowired
	IEnrollmentServiceClient enrollmentSvcClient;
	
	@Autowired
	IEligibilityDetailsDao offersDao;

	@Override
	public OfferDetailsResponse getOffers(OfferDetailsRequest offerDetailsRequest) {
		
		EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
		EnrollmentResponse enrollmentResp = enrollmentSvcClient.enrollment(enrollmentRequest);
		
		OfferDetailsDaoRequest daoDetailsDaoRequest = new OfferDetailsDaoRequest();
		OfferDetailsDaoResp offerDetailsDaoResp = offersDao.getOffers(daoDetailsDaoRequest);
		
		OfferDetailsResponse offerDetailsResponse = new OfferDetailsResponse();
		
		// TODO Auto-generated method stub
		return offerDetailsResponse;
	}

}
