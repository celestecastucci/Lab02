package it.polito.tdp.alien;

public class Dizionario {
	
	String parolaAliena;
	String traduzione;
	
	
	
	
	public Dizionario(String parolaAliena, String traduzione) {
		super();
		this.parolaAliena = parolaAliena;
		this.traduzione = traduzione;
	}
	public String getParolaAliena() {
		return parolaAliena;
	}
	public void setParolaAliena(String parolaAliena) {
		this.parolaAliena = parolaAliena;
	}
	public String getTraduzione() {
		return traduzione;
	}
	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}
	
	

}
