package bg.challenge.props;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {

    private static String url;
    private static String apiKey;
    private static String date;

    private App(){
        this.load();
    }


    public void load() {
        InputStream is =  getClass().getClassLoader().getResourceAsStream("app.properties");
        Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = p.getProperty("url");
        apiKey = p.getProperty("apiKey");
        date = p.getProperty("date");
    }

    public static String getUrl() {
        if (url == null) {
            new App();
        }
        return url;
    }

    public static String getApiKey() {
        if (apiKey == null) {
            new App();
        }
        return apiKey;
    }

    public static String getDate() {
        if (date == null) {
            new App();
        }
        return date;
    }
}
