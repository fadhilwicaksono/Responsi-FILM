/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.MovieModel;
import javax.swing.JOptionPane;


/**
 *
 * @author HP
 */
public class MovieController {
   MovieModel modelmovie;
   Object[][] modelmovies = new Object[250][4];
   
    private Object[][] movie;
    public MovieController(MovieModel modelmovie){
       this.modelmovie = modelmovie;
    }
    
    public Object[][] index(){
       movie = modelmovie.getMovie();
       return movie;
   } 
    
    public void save(String judul, double alur, double penokohan, double akting){
        boolean found = false;
        for (int i = 0; movie[i][0] != null; i++) {
            if (movie[i][0].toString().equals(judul)){
                found = true;
                break;
            }
        }
        if (found){
        } else {
            if (alur > 5.0 || penokohan > 5.0 || akting > 5.0){
            } else if(alur < 0 || penokohan < 0 || akting < 0){
            } else {
                modelmovie.insert(judul, alur, penokohan, akting);
            }
        }
    }
    
    public void update(String judul, double alur, double penokohan, double akting){
        boolean found = false;
        int num = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                num = i;
                found = true;
                break;
            }
        }
        
        if (found){
            if(alur > 5.0 || penokohan > 5.0 || akting > 5.0){
            } else if(alur < 0 || penokohan < 0 || akting < 0){
            } else{
                modelmovie.update(movie[num][0].toString(), alur, penokohan, akting);
            }
        } else {
        }
    }
    
    public void delete(String judul){
        boolean found = false;
        int num = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(judul)){
                num = i;
                found = true;
                break;
            }
        }
        
        if (found){
            modelmovie.delete(movie[num][0].toString());
        }else{
        }
    }
}
