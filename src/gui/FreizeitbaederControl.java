package gui;
   
import java.io.IOException;

import business.Freizeitbad;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class FreizeitbaederControl {
	  
   
	protected FreizeitbaederView freizeitbaederView;
	private business.FReizeitbaederModel freizeitbaederModel;
    
    public FreizeitbaederControl(Stage primaryStage){
    	this.freizeitbaederModel = new business.FReizeitbaederModel();
    	this.freizeitbaederView = new FreizeitbaederView(primaryStage, this, this.freizeitbaederModel);
    }
    
    void nehmeFreizeitbadAuf(){
    	try{
    		this.freizeitbaederModel.setBad( 
    				new Freizeitbad(
    						this.freizeitbaederView.getTxtName().getText(),
    						this.freizeitbaederView.getTxtGeoeffnetVon().getText(),
    						this.freizeitbaederView.getTxtGeoeffnetBis().getText(),
    						this.freizeitbaederView.getTxtBeckenlaenge().getText(),
    						this.freizeitbaederView.getTxtWassTemperatur().getText())
    				);
    		this.freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde aufgenommen!");
       	}
       	catch(PlausiException exc){
       		this.freizeitbaederView.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
     	}
    }
    
    void zeigeFreizeitbaederAn(){
    	if(this.freizeitbaederModel.getBad() != null){
    		this.freizeitbaederView.getTxtAnzeige().setText(
    				this.freizeitbaederModel.getBad().gibFreizeitbadZurueck(' '));
    	}
    	else{
    		this.freizeitbaederView.zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
    	}
    }
    
    void schreibeFreizeitbaederInDatei(String typ){
    	 try{
    		 if("csv".equals(typ)){
    			 this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
 
    		 }
    		 else{
    			 freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
    		 }
    	 }
    	catch(IOException exc){
    		freizeitbaederView.zeigeFehlermeldungAn("IOException beim Speichern!");
    	}
    	catch(Exception exc){
    		freizeitbaederView.zeigeFehlermeldungAn("Unbekannter Fehler beim Speichern!");
    	}
    }

}
