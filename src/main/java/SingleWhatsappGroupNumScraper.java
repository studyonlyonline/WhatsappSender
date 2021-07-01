import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SingleWhatsappGroupNumScraper {

    private CSVFileWriter CSVFileWriter;
    private List<String> paths = Arrays.asList(
            "BkHWpeViQcQAAHyk9ApbzN"
//            "Fuyzw66V6NVFWNrX37DIl0"
        );

    public SingleWhatsappGroupNumScraper() {
        CSVFileWriter = new CSVFileWriter();
    }

    public void execute(WebDriver driver, String filePath) throws Exception {

        Set<String> finalData = new HashSet<>();

        for (int i=0; i < paths.size(); i++) {
            String path = paths.get(i);
            path = "https://web.whatsapp.com/accept?code=" + path;
            driver.get(path);

            System.out.println("Final URL " + path);
            Thread.sleep(10000);

            //if alert exisits
            try {
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert text  " + alert.getText());
                alert.accept();
            } catch (Exception ex) {
                System.out.println("no such alert");
            }

            System.out.println();
            //script to join new group
            try {
                WebElement m = driver.findElement(By.xpath("//div[@data-animate-modal-body='true']/div[2]/div[2]"));
                System.out.println("Element with text(): " + m.getText());
                System.out.println("finding element with text");
                m.click();
            } catch (Exception ex) {
                System.out.println("failed finding element to join group " + ex);
            }

            Thread.sleep(10000);
            System.out.println();

            //script to get all phone num
            try {
                WebElement m = driver.findElement(By.xpath("//header/div[2]/div[2]"));
                if (Objects.nonNull(m.getText())) {
                    finalData.add(m.getText());
                }
                System.out.println("Element with phone num(): " + m.getText());
                System.out.println("finding element with text");
                m.click();
            } catch (Exception ex) {
                System.out.println("failed finding element with text " + ex);
            }
        }

        CSVFileWriter.writeToFile(finalData, filePath);
    }


}
