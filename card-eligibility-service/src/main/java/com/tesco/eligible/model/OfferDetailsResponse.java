package com.tesco.eligible.model;

import java.util.List;

import lombok.Data;

@Data
public class OfferDetailsResponse {
	
	
	private StatusBlock statusBlock;
	private List<OfferDetails> offers;

}
