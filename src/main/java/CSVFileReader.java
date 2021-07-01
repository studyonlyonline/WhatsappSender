import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class CSVFileReader {

    public Set<String> readFromCSV(String filePath, String headerToReadFrom) throws Exception{

        Set<String> phoneNumSet = new HashSet<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filePath));
        CSVParser csvParser = new CSVParser(reader,
                CSVFormat.DEFAULT.withHeader(Constants.PHONE_NUM_HEADER).withIgnoreHeaderCase().withTrim());

        int cnt = 0;

        for (CSVRecord csvRecord: csvParser) {
            cnt++;
            if (cnt == 1 ){
                continue;
            }
            // Accessing Values by Column Index
//            String phoneNum = csvRecord.get(0);

            //Accessing the values by column header name
            String phoneNum = csvRecord.get(headerToReadFrom);
            phoneNumSet.add(phoneNum);

            //Printing the record
            System.out.println("Record Number - " + csvRecord.getRecordNumber());
            System.out.println("phoneNum : " + phoneNum);
            System.out.println("\n\n");
        }

        return phoneNumSet;
    }
}
