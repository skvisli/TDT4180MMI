package oving2;

import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class AppointmentController implements Initializable{

	Appointment app = new Appointment();

    @FXML private TextField eventTitle;
    @FXML private TextField locationTextField;
    @FXML private DatePicker date;
    @FXML private TextField from;
    @FXML private TextField to;
    @FXML private CheckBox allDay;
    @FXML private CheckBox repeat;
    @FXML private TextField frequency;
    @FXML private DatePicker endDate;
    @FXML private Button save;
    @FXML private Button clear;
    @FXML private HBox repeatOptions;
    @FXML private Label feedback;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//Adds listener to repeat-checkBox
		repeat.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if(newValue){
					repeatOptions.setDisable(false);
				}else{
					repeatOptions.setDisable(true);
				}
			}
		});
	}
    

    //----------------- Save -----------------------
	

    @FXML
    void save(ActionEvent event) {
    	
    	String feedbackString = "";
    	
    	//Checks eventTitle
    	if(!eventTitle.getText().isEmpty()){
    		app.setFormal(eventTitle.getText());
    	}else{
    		eventTitle.getStyleClass().add("notValid"); // NOT WORKING
    		feedbackString += "Appointment must have a title\n";
    	}
    	
    	
    	app.setDato(date.getValue());
    	app.setSlutt(endDate.getValue());
    	
    	//Checks time format
    	try {
    		app.setFra(LocalTime.parse(from.getText()));
		} catch (Exception e) {
			from.getStyleClass().add("notValid");
			feedbackString += "From and To must be in the format: 'HH:MM'\n";
		}
    	try {
    		app.setTil(LocalTime.parse(to.getText()));
		} catch (Exception e) {
			to.getStyleClass().add("notValid");
			feedbackString += "From and To must be in the format: 'HH:MM'\n";
		}
    	
    	
    	//Checks location format
    	if(!locationTextField.getText().isEmpty()){
    		if(locationTextField.getText().matches("[A-z]+[-][A-z]+[ ][0-9]+")){
    			app.setRom(locationTextField.getText());
    			
    			feedback.setText("Appointment saved");
    			System.out.println(app.toString());
    			clearAll(); 
    		}
    		else{
    			locationTextField.getStyleClass().add("notValid");
    			feedbackString += "Location must be in format 'IT-vest 115'\n";
    		}
    		
    	}

    	//Checks if repeat is selected and if #days is valid
    	if(repeat.isSelected()){
    		if(frequency.getText().matches("[0-9]")){
    			//app.setRom(locationTextField.getText());
    			System.out.println("riktig");
    		}else{
    			frequency.getStyleClass().add("notValid");
    			feedbackString += "Repeat must be a number\n";
    		} 	
    	}

    	feedback.getStyleClass().add("redText");
    	feedback.setText(feedbackString);
    	System.out.println(app.toString());

    }

    //----------------- All Day -----------------------

    String tempFrom;
    String tempTo;

    @FXML
    void allDay(ActionEvent event) {
        if(allDay.isSelected()){
            tempFrom = from.getText();
            tempTo = to.getText();
            from.setText("00:00");
            to.setText("23:59");
        }
        else{
            from.setText(tempFrom);
            to.setText(tempTo);
        }
    }
   

    //----------------- Clear --------------------------

    @FXML
    void clear(ActionEvent event){
        clearAll();
    }

    void clearAll(){
        eventTitle.setText("");
        locationTextField.setText("");
        date.setValue(null);
        from.setText("08:00");
        to.setText("12:00");
        allDay.setSelected(false);
        repeat.setSelected(false);
        frequency.setText("");
        endDate.setValue(null);
        feedback.setText("");
        
       locationTextField.getStyleClass().add("isValid");
       frequency.getStyleClass().add("isValid");
       from.getStyleClass().add("isValid");
       to.getStyleClass().add("isValid");
    }
}