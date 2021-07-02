/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam6m4finalprojects21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author jacobmcintosh
 */
public class NotesModel extends AbstractModel {
    Note note;
    
    public void NotesModel(){
        note = new Note();
    }
    
    // parts of the following code were referenced using the object serialization lecture from class
    public void handleOpen(File file){
        if(file != null){
            FileInputStream fileIn;
            try {
                fileIn = new FileInputStream(file.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn); 
                
                note = (Note) in.readObject();
                
                in.close(); 
                fileIn.close(); 
                fillFormFromNote(note); 
                
            } catch (FileNotFoundException ex) {
                String message = "File not found exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex); 
                
            } catch (IOException ex) {
                String message = "IO exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex);
                
            } catch (ClassNotFoundException ex) {
                String message = "Class not found exception occured while opening " + file.getPath(); 
                displayExceptionAlert(message, ex); 
            }
        }
    }
    
    public boolean checkNote(){
        firePropertyChange("createNote", null, true);
        return note != null;
    }
    
    public void handleSave(File file){
        if(file != null){
            try {
                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                
                out.writeObject(note);
                out.close();
                fileOut.close();
                
            } catch (FileNotFoundException ex) {
                String message = "File not found exception occurred while saving to " + file.getPath();
                displayExceptionAlert(message, ex);
                
            } catch (IOException ex) {
                String message = "IOException occured while saving to " + file.getPath();
                displayExceptionAlert(message, ex);
            }
        }
    }
    
    public Note createNoteFromFormData(String titleText, String noteBody) {
        Note n = new Note();
        n.setTitle(titleText);
        n.setBody(noteBody);
        
        return n;
    }
    
    public void fillFormFromNote(Note note){
        firePropertyChange("TitleText", null, note.getTitle());
        firePropertyChange("NoteBody", null, note.getBody());
    }
    
    public void displayExceptionAlert(String message, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(message);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
    
    public void displayErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
    // end of reference
}
