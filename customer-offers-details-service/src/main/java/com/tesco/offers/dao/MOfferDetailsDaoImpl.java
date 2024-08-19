package com.tesco.offers.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.tesco.offers.model.OfferDetailsDaoRequest;
import com.tesco.offers.model.OfferDetailsDaoResp;
import com.tesco.offers.model.GOfferDetailsDaoResp;
import com.tesco.offers.model.OfferDaoDetails;

@Component
public class MOfferDetailsDaoImpl implements IOfferDetailsDao {

	@Override
	@Async("threadPoolExecutor")
	public CompletableFuture<OfferDetailsDaoResp> getOffers(OfferDetailsDaoRequest daoDetailsRuquest) {

		List<OfferDaoDetails> mOffersList = new ArrayList<>();

		OfferDaoDetails offerDaoDetails = new OfferDaoDetails();
		offerDaoDetails.setOid("12345");
		offerDaoDetails.setName("mobile");
		offerDaoDetails.setStDate("06-24");
		offerDaoDetails.setEndDate("12-24");
		offerDaoDetails.setImageUrl("http://amazon.com/mobile/iphone");
		offerDaoDetails.setType("m-offers");
		offerDaoDetails.setDesc("good");

		OfferDaoDetails offerDaoDetails1 = new OfferDaoDetails();
		offerDaoDetails.setOid("12345");
		offerDaoDetails.setName("mobile");
		offerDaoDetails.setStDate("06-24");
		offerDaoDetails.setEndDate("12-24");
		offerDaoDetails.setImageUrl("http://amazon.com/mobile/iphone");
		offerDaoDetails.setType("m-offers");
		offerDaoDetails.setDesc("good");

		OfferDaoDetails offerDaoDetails2 = new OfferDaoDetails();
		offerDaoDetails.setOid("12345");
		offerDaoDetails.setName("mobile");
		offerDaoDetails.setStDate("06-24");
		offerDaoDetails.setEndDate("12-24");
		offerDaoDetails.setImageUrl("http://amazon.com/mobile/iphone");
		offerDaoDetails.setType("m-offers");
		offerDaoDetails.setDesc("good");

		mOffersList.add(offerDaoDetails);
		mOffersList.add(offerDaoDetails1);
		mOffersList.add(offerDaoDetails2);

		OfferDetailsDaoResp offerDetailsDaoResp = new OfferDetailsDaoResp();

		offerDetailsDaoResp.setRespCode("0");
		offerDetailsDaoResp.setRespMsg("success");
		offerDetailsDaoResp.setOffersList(mOffersList);
		
		return CompletableFuture.completedFuture(offerDetailsDaoResp);
	}

}
