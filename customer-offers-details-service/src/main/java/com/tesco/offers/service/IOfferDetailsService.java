package com.tesco.offers.service;

import java.util.concurrent.ExecutionException;

import com.tesco.offers.model.OfferDetailsRequest;
import com.tesco.offers.model.OfferDetailsResponse;

public interface IOfferDetailsService {
	
	OfferDetailsResponse getOffers(OfferDetailsRequest offerDetailsRequest) throws InterruptedException, ExecutionException;

}
