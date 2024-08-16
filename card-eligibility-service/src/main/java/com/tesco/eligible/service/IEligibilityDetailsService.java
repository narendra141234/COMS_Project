package com.tesco.eligible.service;

import com.tesco.eligible.model.OfferDetailsRequest;
import com.tesco.eligible.model.OfferDetailsResponse;

public interface IEligibilityDetailsService {
	
	OfferDetailsResponse getOffers(OfferDetailsRequest offerDetailsRequest);

}
