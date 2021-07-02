/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam6m4finalprojects21;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author jacobmcintosh
 */
public class NotesController implements Initializable, PropertyChangeListener {

    @FXML
    private VBox vBox;
    @FXML
    private HBox notesAppHeaderHBox;
    @FXML
    private Label notesAppTitle;
    @FXML
    private HBox titleHBox;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField titleText;
    @FXML
    private HBox noteBodyHBox;
    @FXML
    private HTMLEditor noteBody;
    
    private Stage stage;
    private Scene notesScene;
    private Scene aboutScene;
    private AboutPageController aboutPageController;
    
    NotesModel notesModel;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        notesModel = new NotesModel();
        notesModel.addPropertyChangeListener(this);
    }    
    
    public void start(Stage stage) {
        this.stage = stage;
        notesAppHeaderHBox.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        titleHBox.setBackground(new Background(new BackgroundFill(Color.GOLDENROD, CornerRadii.EMPTY, Insets.EMPTY)));
        vBox.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        notesScene = stage.getScene();
    }
    
    @FXML
    private void handleNew(ActionEvent event) {
        titleText.setText("");
        noteBody.setHtmlText("");
    }

    // the following code was referenced from the object serialization lecture in class
    @FXML
    private void handleOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        notesModel.handleOpen(file);
    }

    @FXML
    private void handleSave(ActionEvent event) {
        
        if(notesModel.checkNote()){
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(stage);
            notesModel.handleSave(file);
        }
    }

    @FXML
    private void handleClose(ActionEvent event) {
        stage.close();
    }

    @FXML
    private void handleAbout(ActionEvent event) {
        try {
            if(aboutScene == null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutPage.fxml"));
                Parent aboutPageRoot = loader.load();
                aboutPageController = loader.getController();
                aboutPageController.notesScene = notesScene;
                aboutPageController.notesController = this;
                aboutScene = new Scene(aboutPageRoot);
            }
        
        } catch (Exception ex) {
            
        }
        
        stage.setScene(aboutScene);
        aboutPageController.start(stage);
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("TitleText")){
            titleText.setText(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("NoteBody")){
            noteBody.setHtmlText(evt.getNewValue().toString());
        } else if (evt.getPropertyName().equals("createNote")){
            notesModel.note = notesModel.createNoteFromFormData(titleText.getText(), noteBody.getHtmlText());
        }
    }
}
