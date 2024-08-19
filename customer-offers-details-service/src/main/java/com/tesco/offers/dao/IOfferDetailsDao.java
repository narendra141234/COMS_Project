package com.tesco.offers.dao;


import java.util.concurrent.CompletableFuture;

import com.tesco.offers.model.OfferDetailsDaoRequest;
import com.tesco.offers.model.OfferDetailsDaoResp;

public interface IOfferDetailsDao {
	
	CompletableFuture<OfferDetailsDaoResp> getOffers(OfferDetailsDaoRequest daoDetailsRuquest);

}
