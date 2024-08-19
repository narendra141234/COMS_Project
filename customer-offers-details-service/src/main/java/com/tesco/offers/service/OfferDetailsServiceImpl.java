package com.tesco.offers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.catalina.startup.SetAllPropertiesRule;
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
import com.tesco.offers.model.OfferDaoDetails;
import com.tesco.offers.model.OfferDetails;
import com.tesco.offers.model.OfferDetailsRequest;
import com.tesco.offers.model.OfferDetailsResponse;
import com.tesco.offers.model.StatusBlock;
import com.tesco.offers.serviceclient.IEnrollmentServiceClient;

@Component
public class OfferDetailsServiceImpl implements IOfferDetailsService {

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
	public OfferDetailsResponse getOffers(OfferDetailsRequest offerDetailsRequest) throws InterruptedException, ExecutionException {

		EnrollmentRequest enrollmentRequest = new EnrollmentRequest();

		EnrollmentResponse enrollmentResp = enrollmentSvcClient.enrollment(enrollmentRequest);

		OfferDetailsDaoRequest daoDetailsDaoRequest = new OfferDetailsDaoRequest();

		// GOfferDetailsDaoResp offerDetailsDaoResp =
		// offersDao.getOffers(daoDetailsDaoRequest);

		// if the request type is goffers then make only goffersdao call and get
		// response

		// if the request type is moffers then make only moffersdao call and get
		// response

		// if the request type is poffers then make only poffersdao call and get
		// response

		// if nothing is mentioned or all mentioned in request call all backends to get
		// data i.e implement
		// parallel calls multi threading to invoke all the parallel calls and get
		// response

		// call poffers dao
		CompletableFuture<OfferDetailsDaoResp> poffersResp = poffersdao.getOffers(daoDetailsDaoRequest);

		// call moffers dao
		CompletableFuture<OfferDetailsDaoResp> moffersResp = moffersdao.getOffers(daoDetailsDaoRequest);

		// call goffers dao
		CompletableFuture<OfferDetailsDaoResp> goffersResp = goffersdao.getOffers(daoDetailsDaoRequest);

		OfferDetailsResponse offerDetailsResponse = new OfferDetailsResponse();

		List<OfferDetails> offersList = new ArrayList<>();

		for (OfferDaoDetails daoDetails : poffersResp.get().getOffersList()) {

			OfferDetails offerDetails = new OfferDetails();
			offerDetails.setOid(daoDetails.getOid());
			offerDetails.setName(daoDetails.getName());
			offerDetails.setImageUrl(daoDetails.getImageUrl());
			offerDetails.setStDate(daoDetails.getStDate());
			offerDetails.setEndDate(daoDetails.getEndDate());
			offerDetails.setType(daoDetails.getType());
			offerDetails.setDesc(daoDetails.getDesc());

			offersList.add(offerDetails);

		}
		for (OfferDaoDetails daoDetails : moffersResp.get().getOffersList()) {

			OfferDetails offerDetails = new OfferDetails();
			offerDetails.setOid(daoDetails.getOid());
			offerDetails.setName(daoDetails.getName());
			offerDetails.setImageUrl(daoDetails.getImageUrl());
			offerDetails.setStDate(daoDetails.getStDate());
			offerDetails.setEndDate(daoDetails.getEndDate());
			offerDetails.setType(daoDetails.getType());
			offerDetails.setDesc(daoDetails.getDesc());

			offersList.add(offerDetails);

		}

		for (OfferDaoDetails daoDetails : goffersResp.get().getOffersList()) {

			OfferDetails offerDetails = new OfferDetails();
			offerDetails.setOid(daoDetails.getOid());
			offerDetails.setName(daoDetails.getName());
			offerDetails.setImageUrl(daoDetails.getImageUrl());
			offerDetails.setStDate(daoDetails.getStDate());
			offerDetails.setEndDate(daoDetails.getEndDate());
			offerDetails.setType(daoDetails.getType());
			offerDetails.setDesc(daoDetails.getDesc());

			offersList.add(offerDetails);

		}

		StatusBlock statusBlock = new StatusBlock();
		offerDetailsResponse.setStatusBlock(statusBlock);
		offerDetailsResponse.setOffers(offersList);

		return offerDetailsResponse;
	}

}
