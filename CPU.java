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
class CPU {
     private double clock;
    private int core;
    private String merek;
    
    public CPU(String merek,  double clock, int core){
        this.merek = merek;
        this.core = core;
        this.clock = clock;
    }
    
    public double getClock(){
        return clock;
    }
    
    public int getCore(){
        return core;
    }
    
    public String getMerek(){
        return merek;
    }
    
}
