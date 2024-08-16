package com.tesco.offers.model;

import java.util.List;

import lombok.Data;

@Data
public class MOfferDetailsDaoResp {
	
	private String respCode;
	private String respMag;
	
	private List<MOfferDetails> moffersList;

}
