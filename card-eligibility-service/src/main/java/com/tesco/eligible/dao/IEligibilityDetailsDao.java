package com.tesco.eligible.dao;

import com.tesco.eligible.model.OfferDetailsDaoRequest;
import com.tesco.eligible.model.OfferDetailsDaoResp;

public interface IEligibilityDetailsDao {
	
	OfferDetailsDaoResp getOffers(OfferDetailsDaoRequest daoDetailsRuquest);

}
