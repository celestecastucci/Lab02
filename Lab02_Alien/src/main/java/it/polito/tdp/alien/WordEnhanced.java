package it.polito.tdp.alien;

import java.util.LinkedList;

public class WordEnhanced {
	
	String parolaAliena;
	LinkedList<String>listaTraduzioni= new LinkedList<>();
	
	
	
	public WordEnhanced(String parolaAliena) {
		super();
		this.parolaAliena = parolaAliena;
	}


	@Override
	public String toString() {
		
		String s="";
		for(String ss: listaTraduzioni) {
			s+=ss+"\n";
		}
		return s;
	}

	
	
}
