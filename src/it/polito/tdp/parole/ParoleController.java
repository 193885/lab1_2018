package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco = new Parole() ; ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;
    
    @FXML // fx:id="txtTime"
    private TextArea txtTime; // Value injected by FXMLLoader


    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnCancella"
    private Button btnCancella; // Value injected by FXMLLoader

    @FXML
    void doInsert(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	long startTime = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	long stopTime = System.nanoTime();
    	
    	List <String> ordinata= new LinkedList<>(elenco.getElenco());
    	
    	for(String s : ordinata){
        	
        	txtResult.appendText(s+"\n");
    	}
    	
    	long estimatedTime = stopTime - startTime;
    	
    	txtTime.clear();
    	
    	txtTime.setText(""+estimatedTime/ 1e9+ " secondi");
    	txtParola.clear();
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
 		txtResult.clear();
 		
 		long startTime = System.nanoTime();

    	elenco.reset();
    	
    	long stopTime = System.nanoTime();
    	
    	long estimatedTime = stopTime - startTime;
    	
    	txtTime.clear();
    	
    	txtTime.setText(""+estimatedTime/ 1e9+ " secondi");
        	
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	long startTime = System.nanoTime();

    	elenco.remove(txtResult.getSelectedText());
    	
    	long stopTime = System.nanoTime();
    	
    	List <String> ordinata= new LinkedList<>(elenco.getElenco());
    	
    	txtResult.clear();
    	for(String s : ordinata){
        	
        	txtResult.appendText(s+"\n");
    	}
    	
    	long estimatedTime = stopTime - startTime;
    	
    	txtTime.clear();
    	
    	txtTime.setText(""+estimatedTime/ 1e9+ " secondi");

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Parole.fxml'.";

    }
}
