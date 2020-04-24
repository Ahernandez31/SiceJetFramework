package com.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightDescription {
	private String TEST;
	private String ADULTS;
	private String FROM;
	private String TO;
	private String DEPARTURE_DATE;
	private String ARRIVAL_DATE;
	private String CHILDREN;
	
	
	
	public FlightDescription() {
		
	}
	
	
	
	
	public FlightDescription(String tEST, String aDULTS, String fROM, String tO, String dEPARTURE_DATE,
			String aRRIVAL_DATE, String cHILDREN) {
		super();
		TEST = tEST;
		ADULTS = aDULTS;
		FROM = fROM;
		TO = tO;
		DEPARTURE_DATE = dEPARTURE_DATE;
		ARRIVAL_DATE = aRRIVAL_DATE;
		CHILDREN = cHILDREN;
	}
	
	
	
	@Override
	public String toString() {
		return "FlightDescription [TEST=" + TEST + ", ADULTS=" + ADULTS + ", FROM=" + FROM + ", TO=" + TO
				+ ", DEPARTURE_DATE=" + DEPARTURE_DATE + ", ARRIVAL_DATE=" + ARRIVAL_DATE + ", CHILDREN=" + CHILDREN
				+ "]";
	}



	public String getTEST() {
		return TEST;
	}
	@JsonProperty("TEST")
	public void setTEST(String tEST) {
		TEST = tEST;
	}
	public String getADULTS() {
		return ADULTS;
	}
	@JsonProperty("ADULTS")
	public void setADULTS(String aDULTS) {
		ADULTS = aDULTS;
	}
	public String getFROM() {
		return FROM;
	}
	@JsonProperty("FROM")
	public void setFROM(String fROM) {
		FROM = fROM;
	}
	public String getTO() {
		return TO;
	}
	@JsonProperty("TO")
	public void setTO(String tO) {
		TO = tO;
	}
	public String getDEPARTURE_DATE() {
		return DEPARTURE_DATE;
	}
	@JsonProperty("DEPARTURE_DATE")
	public void setDEPARTURE_DATE(String dEPARTURE_DATE) {
		DEPARTURE_DATE = dEPARTURE_DATE;
	}
	public String getARRIVAL_DATE() {
		return ARRIVAL_DATE;
	}
	@JsonProperty("ARRIVAL_DATE")
	public void setARRIVAL_DATE(String aRRIVAL_DATE) {
		ARRIVAL_DATE = aRRIVAL_DATE;
	}
	public String getCHILDREN() {
		return CHILDREN;
	}
	@JsonProperty("CHILDREN")
	public void setCHILDREN(String cHILDREN) {
		CHILDREN = cHILDREN;
	}
	
	
	
	
	
	
}
