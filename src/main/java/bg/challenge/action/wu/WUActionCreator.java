package bg.challenge.action.wu;

import bg.challenge.action.Action;
import bg.challenge.action.ActionCreator;
import bg.challenge.action.Payload;
import bg.challenge.json.mapper.ModelMapper;
import bg.challenge.model.wu.WUDailySummary;
import bg.challenge.props.App;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Date;

/**
 * Basic action creator for Weather Underground service
 *
 * Is responsible for fetching data from service
 */
public class WUActionCreator implements ActionCreator {

 // Action creator to fetch daily summary from history request
 public static Action fetchWeatherDailySummary(Date date) {
  Unirest.setObjectMapper((ObjectMapper) new ModelMapper());
  HttpResponse<WUDailySummary> histResponse = null;
  try {
    histResponse = Unirest.get(App.getUrl() + "{apiKey}/history_{hDate}/q/NY/New_York.json") // TODO use java.net.URL
     .routeParam("apiKey", App.getApiKey())
     .routeParam("hDate", App.getDate()) // TODO use java.util.Date
     .asObject(WUDailySummary.class);
  } catch (UnirestException e) {
   e.printStackTrace();
  }
  WUDailySummary summary = histResponse.getBody();
  Payload<WUDailySummary> payload = new Payload<WUDailySummary>();
  payload.setData(summary);
  Action action = new Action();
  action.setType(WUActionType.FETCH_DAILY_SUMMARY);
  action.setPayload(payload);
  return action;
 }
}
