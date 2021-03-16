/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	
	//TreeMap<WordEnhanced,LinkedList<String>>dizionario= new TreeMap<>();
	
	LinkedList<WordEnhanced>dizionario= new LinkedList<>();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btmTranslate"
    private Button btmTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="btlmClear"
    private Button btlmClear; // Value injected by FXMLLoader

   
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String parolaAliena="";
    	String traduzione="";
    	String testoInserito= txtParola.getText().toLowerCase();
    	String array[]= testoInserito.split(" ");
    	
    if(array.length==2) {
    	//CONTROLLO SE ESISTE GIA IN MAPPA --> RESTITUISCO TRADUZIONE MA NON AGGIUNGO PAROLA ALIENA (c'è gia)
    	
    		parolaAliena=array[0];
    		traduzione= array[1];
    		// CONTROLLO SUI DATI INSERITI --> solo lettere maiuscole o minuscole
    		if( parolaAliena.matches(".*[a-z].*")==false && traduzione.matches(".*[a-z].*")==false ) {
    			txtRisultato.setText("ERRORE: inserire parole nel formato corretto");
    			txtParola.clear();
    			return;
    		} 
    		
    		
    			//SE SONO QUI I DATI INPUT SONO GIUSTI
    			
    			//se esiste vedo che la parola esiste nel dizionario ma non esiste la traduzione
    			for(WordEnhanced ww: dizionario) {
					if(ww.parolaAliena.equals(parolaAliena)) {
						for(String s: ww.listaTraduzioni) {
							if(s.equals(traduzione)) { 
								//se la traduzione esiste gia
								
								
		    	txtRisultato.setText(ww.listaTraduzioni.toString());
				txtParola.clear();
				return;
				
			} 
						}
				
						ww.listaTraduzioni.add(traduzione);
						txtRisultato.setText(ww.listaTraduzioni.toString());
						txtParola.clear();
						return;
						}
					
				}
    			
    			
    				//se sono qui non esiste la parola --> creo la nuova parola e la aggiungo alla lista
    				WordEnhanced word= new WordEnhanced(parolaAliena);
    				word.listaTraduzioni.add(traduzione);
    				dizionario.add(word);
    				txtRisultato.setText(""+word.listaTraduzioni.toString());
    		        txtParola.clear();	
    			
    		
    	}
    
    	if(array.length==1) {
    		parolaAliena=array[0];
    		
    		if( parolaAliena.matches(".*[a-z].*")==false) {
    			txtRisultato.setText("ERRORE: inserire parola nel formato corretto");
    			txtParola.clear();
    			return;
    	}
    		
    		//se la parola esiste ritorno la traduzione
    		for(WordEnhanced ww: dizionario) {
				if(ww.parolaAliena.equals(parolaAliena)) {
					
					
			txtRisultato.setText(ww.listaTraduzioni.toString());
			txtParola.clear();
			return;
    		
				}
				}
    		
    		//se non esiste ritorno errore
    			txtRisultato.setText("ERRORE:la parola aliena "+parolaAliena+" non è contenuta nel dizionario");
    			txtParola.clear();
    			return;
    		}
    		
    	
    	}
     
    
   
    
      @FXML
    void handleClear(ActionEvent event) {
    	txtRisultato.clear();

    }
      
      
     
	@FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmTranslate != null : "fx:id=\"btmTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btlmClear != null : "fx:id=\"btlmClear\" was not injected: check your FXML file 'Scene.fxml'.";
}
}