/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;

/**
 *
 * @author Asus
 */
public class HDD extends Storage{
    public int capacity;
    public HDD(int capacity){
        super(capacity);
    }
    
    public String getName(){
        return "HDD";
    }