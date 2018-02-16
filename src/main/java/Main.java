import bg.challenge.action.wu.WeatherActionCreator;
import bg.challenge.model.WUDailySummary;

import java.util.Date;

public class Main {
    public static void main(String [] args) {
        WUDailySummary summary = WeatherActionCreator.fetchWeatherDailySummary(new Date());
        System.out.println(summary.getMaxHumidity());
        System.out.println(summary.getMaxTempC());
        System.out.println(summary.getMinTempC());
        System.out.println(summary.getPrecipitationM());
    }
}