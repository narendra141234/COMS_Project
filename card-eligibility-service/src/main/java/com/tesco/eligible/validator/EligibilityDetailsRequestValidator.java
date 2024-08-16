package com.tesco.eligible.validator;

import org.springframework.stereotype.Component;

import com.tesco.offers.model.OfferDetailsRequest;

@Component
public class EligibilityDetailsRequestValidator {

	public void validateRequest(OfferDetailsRequest offerDetailsRequest) {
		//validate the request data for all the mandatory elements, if any element then throw the
		//userdefined exception
		
	}

}
