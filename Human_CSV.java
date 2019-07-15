package testcsv;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.nio.file.Path;
import java.io.FileReader;
import java.io.FileWriter;

public class Human_CSV implements CSV<Manusia>{
    
    @Override
    public void write(Path path, List<Manusia> items){
        try (FileWriter tulis = new FileWriter(path.toString());){
            StringBuilder men = new StringBuilder();
            for(Manusia human : items){
                
                men.append(human.getNama()); 
                    men.append(",");
                men.append(human.getUmur()); 
                    men.append(",");
                men.append(human.getBerat());
                    men.append(",");
                men.append(human.getJenisKelamin());
                    men.append("\n");
                    
            }
            tulis.write(men.toString());
        } catch (IOException er) {
            System.err.println("I/O error");
        }
    }
    
    @Override
    public List<Manusia> read(Path path) {
        
        List<Manusia> men = new ArrayList<Manusia>();
        
        try(BufferedReader read = new BufferedReader(new FileReader(path.toString()))){
            String s;
            while((s = read.readLine()) != null){
                String[] manusia = s.split(",");
                men.add(new Manusia(manusia[0], Integer.parseInt(manusia[1]), Double.parseDouble(manusia[2]), Boolean.parseBoolean(manusia[3])));
            }
        } catch (IOException er) {
            System.err.println("I/O error");
        }
        return men;     
    }
}
