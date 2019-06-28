/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Computer {
    private CPU cpu;
    private List<Memory> memories;
    private List<Storage> storages;
    private PSU psu;
    
     public Computer(){
        this.memories = new ArrayList<Memory>();
        this.storages = new ArrayList<Storage>();
    }

    
    public void replaceCPU(CPU cpu){
        this.cpu = cpu;
    }
    
    public void replaceMemory(int slot, Memory memory){
        this.memories.add(slot-1,memory);
    }
    
    public void addStorage(Storage storage){
        this.storages.add(storage);
    }
    
    public void replacePSU(PSU psu){
        this.psu = psu;
    }
    
    public String cetakMemory(){
        int memory_capacity = 0;
        String slot = "";
        for(Memory m : memories){
            
            if(m.getCapacity() != 0) {
                memory_capacity = memory_capacity + m.getCapacity();
                slot = slot + "Slot " + (memories.indexOf(m)+1) + ": " + m.getCapacity() + "GB\n";
            }
        }
        
        return "Memory: " + memory_capacity + "GB\n" + slot;
    }
    
    public String cetakStorage(){
        int storage_capacity = 0;
        String  storage = "";
        for(Storage s : storages){
            storage_capacity = storage_capacity + s.getCapacity();
            storage = storage + s.getName() + ": " + s.getCapacity() + "GB\n";
        }
        return "Storage: " + storage_capacity + "GB\n" + storage;
    }
    
    public String getSpec(){
        
        String spec;
        spec = "CPU: " + cpu.getMerek()+ " " + cpu.getClock() + "Ghz " + cpu.getCore() + " core(s)\n" +
                "===\n" +
                cetakMemory() + 
                "===\n" +
                cetakStorage() +
                "===\n" +
                "PSU: " + psu.getDaya() + "watt";
        return spec;
        
    }
   
    
}
