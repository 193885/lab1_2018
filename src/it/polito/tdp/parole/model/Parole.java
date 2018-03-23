package it.polito.tdp.parole.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {

	private List <String> elencoParole;
	
		
	public Parole() {
		elencoParole= new LinkedList<>();
	}
	
	public void addParola(String p) {
		
		elencoParole.add(p);
	}
		
	public List<String> getElenco() {

		Collections.sort(elencoParole);
		
		return elencoParole;
	}
	
	public void reset() {
			
		elencoParole.clear();
		
	}

	public void remove(String selectedText) {
		
		elencoParole.remove(selectedText);
		
	}

}
