/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	
	TreeMap<String,Dizionario>dizionario= new TreeMap<>();

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
    		
    			if(!dizionario.containsKey(parolaAliena)) {
    				Dizionario d= new Dizionario(parolaAliena,traduzione);
    			dizionario.put(d.getParolaAliena(),d);
    				txtRisultato.setText(traduzione);
    		
    				txtParola.clear();
    			} else {
    				txtRisultato.setText(traduzione);
    				
    				txtParola.clear();
    			}
    		
    	}
    	if(array.length==1) {
    		parolaAliena=array[0];
    		if( parolaAliena.matches(".*[a-z].*")==false) {
    			txtRisultato.setText("ERRORE: inserire parola nel formato corretto");
    			txtParola.clear();
    			return;
    	}
    		if(!dizionario.containsKey(parolaAliena)) {
    			txtRisultato.setText("ERRORE:la parola aliena "+parolaAliena+" non è contenuta nel dizionario");
    			txtParola.clear();
    			return;
    		}
    		for(Dizionario d: dizionario.values()) {
    			if(d.getParolaAliena().equals(parolaAliena)) {
    				txtRisultato.setText(d.getTraduzione());
    				txtParola.clear();
    			}
    		}
    		
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