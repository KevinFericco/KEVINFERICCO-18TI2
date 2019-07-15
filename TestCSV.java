package testcsv;

import java.util.List;
import java.io.File;
import java.util.Arrays;

public class TestCSV {

	public static void main(String []args) {
		List<Manusia> m = Arrays.asList(new Manusia[]{
			new Manusia("budi", 20, 60.7, true),
			new Manusia("susi", 20, 40.3, false),
		});
                
		CSV<Manusia> manusiaCSV = new Human_CSV(); 

		manusiaCSV.write(new File("manusia.csv").toPath(), m);

		List<Manusia> o = manusiaCSV.read(new File("manusia.csv").toPath());

	}
}