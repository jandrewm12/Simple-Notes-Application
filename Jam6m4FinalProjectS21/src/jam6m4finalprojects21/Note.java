/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jam6m4finalprojects21;

/**
 *
 * @author jacobmcintosh
 */
public class Note implements java.io.Serializable {
    private String title;
    private String body;
    
    public Note(){
        
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setBody(String body){
        this.body = body;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getBody(){
        return body;
    }
}