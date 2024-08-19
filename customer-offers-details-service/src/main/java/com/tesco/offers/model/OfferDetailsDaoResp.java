package com.tesco.offers.model;

import java.util.List;

import lombok.Data;

@Data
public class OfferDetailsDaoResp {
	
	private String respCode;
	private String respMsg;
	
	private List<OfferDaoDetails> offersList;

}
