import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainExecutor {

    private static ChromeOptions options;
    private static WebDriver driver;
    private static String FILE_PATH_TO_WRITE = "/Volumes/workplace/WhatsappScraper/src/main/resources/csv/customer1.csv";

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Users/gsartha/learning/chromedriverfile/chromedriver_91");

        options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
        driver = new ChromeDriver(options);

//        singleWhatsappGroupNumScraper();
        sendImageMessage();
    }

    private static void singleWhatsappGroupNumScraper() throws Exception {
        SingleWhatsappGroupNumScraper singleWhatsappGroupNumScraper = new SingleWhatsappGroupNumScraper();
        singleWhatsappGroupNumScraper.execute(driver, FILE_PATH_TO_WRITE);
    }

    private static void sendImageMessage() throws Exception {
        SendImageMessage sendImageMessage = new SendImageMessage();
        sendImageMessage.execute(driver, FILE_PATH_TO_WRITE);
    }
}
