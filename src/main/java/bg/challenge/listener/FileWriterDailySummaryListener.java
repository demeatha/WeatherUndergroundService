package bg.challenge.listener;

import bg.challenge.action.Payload;
import bg.challenge.model.wu.WUDailySummary;
import bg.challenge.store.State;
import bg.challenge.store.StoreSubscriber;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class FileWriterDailySummaryListener implements StoreSubscriber{
    @Override
    public void onUpdate(State state) {
        Map<String, Payload> newState = (Map<String, Payload>) state.current();
        WUDailySummary summary = (WUDailySummary) newState.get("daily_summary").getData();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("output.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("Max percentage humidity: " + summary.getMaxHumidity()+"%");
        writer.println("Max Temp in C: " + summary.getMaxTempC()+"℃");
        writer.println("Min Temp in C: " + summary.getMinTempC()+"℃");
        writer.println("Precipitation in mm: " + summary.getPrecipitationM()+"mm");
        writer.close();

    }
}
