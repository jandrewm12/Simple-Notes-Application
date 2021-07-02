/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam6m4finalprojects21;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jacobmcintosh
 */
public class AboutPageController implements Initializable, PropertyChangeListener {

    private Stage stage;
    public Scene notesScene;
    public NotesController notesController;
    
    @FXML
    private VBox aboutPageVBox;
    @FXML
    private HBox aboutHeaderHBox;
    @FXML
    private Label aboutHeader;
    @FXML
    private HBox subtitleHBox;
    @FXML
    private Text subtitle;
    @FXML
    private HBox descriptionHBox;
    @FXML
    private Text description;
    @FXML
    private Button returnButton;
    
    AboutModel aboutModel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        aboutModel = new AboutModel();
        aboutModel.addPropertyChangeListener(this);
    }


    public void start(Stage stage){
        this.stage = stage;
        aboutHeaderHBox.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        aboutPageVBox.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @FXML
    private void returnToNotes(ActionEvent event) {
        stage.setScene(notesScene);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
