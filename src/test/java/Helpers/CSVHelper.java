package Helpers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CSVHelper {
	
    public static String read(String nameFile, String key) throws CsvValidationException {
        try (InputStream input = CSVHelper.class.getClassLoader().getResourceAsStream(nameFile+".csv")) {
            CSVReader reader = new CSVReader(new InputStreamReader(input));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if(nextLine[0].equals(key)) {
					return nextLine[1].toString();
				}
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
