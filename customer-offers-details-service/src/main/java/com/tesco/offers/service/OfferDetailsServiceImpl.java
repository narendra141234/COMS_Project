package com.tesco.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.offers.builder.OfferDetailsRequestBuilder;
import com.tesco.offers.builder.OfferDetailsRespBuilder;
import com.tesco.offers.dao.GOfferDetailsDaoImpl;
import com.tesco.offers.dao.IOfferDetailsDao;
import com.tesco.offers.dao.MOfferDetailsDaoImpl;
import com.tesco.offers.dao.POfferDetailsDaoImpl;
import com.tesco.offers.model.EnrollmentRequest;
import com.tesco.offers.model.EnrollmentResponse;
import com.tesco.offers.model.OfferDetailsDaoRequest;
import com.tesco.offers.model.OfferDetailsDaoResp;
import com.tesco.offers.model.GOfferDetailsDaoResp;
import com.tesco.offers.model.OfferDetailsRequest;
import com.tesco.offers.model.OfferDetailsResponse;
import com.tesco.offers.serviceclient.IEnrollmentServiceClient;

@Component
public class OfferDetailsServiceImpl implements IOfferDetailsService{
	
	@Autowired
	OfferDetailsRequestBuilder offerDtlsReqBuilder;
	
	@Autowired
	OfferDetailsRespBuilder offerDtlsResBuilder;
	
	@Autowired
	IEnrollmentServiceClient enrollmentSvcClient;
	
	@Autowired
	POfferDetailsDaoImpl poffersdao;
	
	@Autowired
	MOfferDetailsDaoImpl moffersdao;
	
	@Autowired
	GOfferDetailsDaoImpl goffersdao;
	
	
	@Override
	public OfferDetailsResponse getOffers(OfferDetailsRequest offerDetailsRequest) {
		
		EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
		
		EnrollmentResponse enrollmentResp = enrollmentSvcClient.enrollment(enrollmentRequest);
		
		OfferDetailsDaoRequest daoDetailsDaoRequest = new OfferDetailsDaoRequest();
		
		//GOfferDetailsDaoResp offerDetailsDaoResp = offersDao.getOffers(daoDetailsDaoRequest);
		
		//if the request type is goffers then make only goffersdao call and get response
		
		//if the request type is moffers then make only moffersdao call and get response
		
		//if the request type is poffers then make only poffersdao call and get response
		
		//if nothing is mentioned or all mentioned in request call all backends to get data i.e implement
		//parallel calls multi threading to invoke all the parallel calls and get response
		
		
		OfferDetailsResponse offerDetailsResponse = new OfferDetailsResponse();
		

		return offerDetailsResponse;
	}

}
