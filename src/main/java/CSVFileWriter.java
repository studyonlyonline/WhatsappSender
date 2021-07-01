import org.apache.commons.collections4.MapUtils;
import org.apache.commons.collections4.SetUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.exec.util.StringUtils;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

public class CSVFileWriter {

    public void writeToFile(Map<String, String> data) throws Exception {
        try {

            //We have to create the CSVPrinter class object
            Writer writer = Files.newBufferedWriter(Paths.get("/Users/gsartha/learning/javaLearning/resources/csv/customer.csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Phone-Number"));

            MapUtils.emptyIfNull(data).forEach((k, v) -> {
                try {
                    String splitData[] = v.split(", ");
                    for (String num: splitData) {
                        csvPrinter.printRecord(k, num);
                        System.out.println("Num " + num);
                    }
                    System.out.println("completed writing in file");

                } catch (IOException ex) {
                    System.out.println("error in writing");
                }

            });

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(Set<String> data, String filePathToWrite) throws Exception {
        try {

            //We have to create the CSVPrinter class object
            Writer writer = Files.newBufferedWriter(Paths.get(filePathToWrite));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(Constants.PHONE_NUM_HEADER));

            SetUtils.emptyIfNull(data).forEach(value -> {
                try {
                    String splitData[] = value.split(", ");
                    for (String num: splitData) {
                        String cleanedNum = cleanPhoneNum(num);

                        if (cleanedNum.length() != 0) {
                            csvPrinter.printRecord(cleanedNum);
                        }
                        System.out.println("Num " + cleanPhoneNum(num));
                    }
                } catch (IOException ex) {
                    System.out.println("error in writing phone num in file");
                }

            });

            csvPrinter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String cleanPhoneNum(String val) {
        String outputNum = "";
        for (int i=0;i<val.length(); i++) {
            char c = val.charAt(i);

            if (c >=48 && c<=57) {
                outputNum = outputNum + c;
            }
        }

        return outputNum;
    }

}
