import org.apache.commons.collections4.SetUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class SendImageMessage {

    private CSVFileReader csvFileReader;
    private String HEADER_TO_READ_FROM_CSV = Constants.PHONE_NUM_HEADER;
    private String IMAGE_FILE_PATH = "/Users/gsartha/Desktop/videorecording/bed-table.jpg" ;

    List<String> toIgnore = Arrays.asList("917979919897", "917310763053");

    public SendImageMessage() {
        csvFileReader = new CSVFileReader();
    }

    public void execute(WebDriver driver, String filePath) throws Exception {
        Set<String> phoneNums = csvFileReader.readFromCSV(filePath, HEADER_TO_READ_FROM_CSV);

        SetUtils.emptyIfNull(phoneNums).stream()
                .filter(num -> !toIgnore.contains(num))
                .forEach(num -> {
            try {
                System.out.println("Phone num to send message " + num);

                String path = "https://web.whatsapp.com/send?phone=" + num + "&text=" + PromoMessageConstants.BBO_PROMO;
//            String path = "https://web.whatsapp.com/send?phone=" + num ;
                driver.get(path);

                sleepForSeconds(10000);

                WebElement attachmentBox = driver.findElement(By.xpath("//div[@title = \"Attach\"]"));
                attachmentBox.click();

                sleepForSeconds(7000);

                WebElement imageBox = driver.findElement(By.xpath("//input[@accept=\"image/*,video/mp4,video/3gpp,video/quicktime\"]"));
                imageBox.sendKeys(IMAGE_FILE_PATH);

                sleepForSeconds(10000);

                WebElement send_button = driver.findElement(By.xpath("//span[@data-icon=\"send\"]"));
                sleepForSeconds(1000);
                send_button.click();
                sleepForSeconds(10000);

                System.out.println("message sent successfully");

            } catch (Exception ex) {
                System.out.println("Failure in sending message");
            }
        });
    }

    private static void sleepForSeconds(int milliseconds) {
        try {
            System.out.println("Sleeping for " + milliseconds/1000 + "seconds");
            Thread.sleep(milliseconds);
        } catch (Exception ex) {
            System.out.println("Error in Thread.sleep " + ex);
        }
    }

}
