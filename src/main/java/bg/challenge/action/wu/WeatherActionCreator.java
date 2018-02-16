package bg.challenge.action.wu;

import bg.challenge.action.ActionCreator;
import bg.challenge.json.mapper.ModelMapper;
import bg.challenge.model.WUDailySummary;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Date;

public class WeatherActionCreator implements ActionCreator {
 //TODO in the future will action
 public static WUDailySummary fetchWeatherDailySummary(Date date) {
  Unirest.setObjectMapper((ObjectMapper) new ModelMapper());
  HttpResponse<WUDailySummary> histResponse = null;
  try {
    histResponse = Unirest.get("http://api.wunderground.com/api/{apiKey}/history_{hDate}/q/NY/New_York.json")
     .routeParam("apiKey", "ef2168d2342c8ede") // TODO un-hardcode it
     .routeParam("hDate", "20171030") // TODO un-hardcode it
     .asObject(WUDailySummary.class);
  } catch (UnirestException e) {
   e.printStackTrace();
  }
  WUDailySummary summary = histResponse.getBody();
  return summary;
 }
}
