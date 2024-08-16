package com.tesco.offers.model;

import java.util.List;

import lombok.Data;

@Data
public class POfferDetailsDaoResp {
	
	private String respCode;
	private String respMag;
	
	private List<POfferDetails> poffersList;

}
