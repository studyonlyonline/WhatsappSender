import java.net.URLEncoder;

public class PromoMessageConstants {

    public static String BBO_PROMO = getEncodedUrls("Tired of Sitting on Chair while working from Home? \n" +
            "Now sit comfortably on bed and work on this bed table @ Rs 456." +
            "\n" +
            "https://amzn.to/2TNMsgv\n" +
            "\n" +
            "➖➖➖➖\n" +
            "Want Latest Deals & offers at Once Place? Join here to Get a discount/Cashback on your shopping every time.\n" +
            "\n" +
            "✔️Whatsapp Channel\uD83D\uDC47\n" +
            "https://chat.whatsapp.com/K3CbHFhehKtIfIzeQ0zX1X\n" +
            "\n" +
            "✔️Facebook Channel\uD83D\uDC47\n" +
            "https://www.facebook.com/BBO-106295721621670");

    private static String BBOWhatsappUrl = getEncodedUrls("https://chat.whatsapp.com/K3CbHFhehKtIfIzeQ0zX1X");

    public static String getEncodedUrls(String url){
//        System.out.println("string url " + url);
        try {
            String encodedText = URLEncoder.encode(url, "UTF-8");
//            System.out.println("encoded text " + encodedText);
            return encodedText;
        } catch (Exception ex) {
            System.out.println("exception in encoding");
            return "";
        }
    }
}
