package bg.challenge.listener;

import bg.challenge.action.Payload;
import bg.challenge.model.wu.WUDailySummary;
import bg.challenge.store.State;
import bg.challenge.store.StoreSubscriber;

import java.util.Map;

public class StandardOutputDailySummaryListener implements StoreSubscriber {

    @Override
    public void onUpdate(State state) {
        Map<String, Payload> newState = (Map<String, Payload>) state.current();
        WUDailySummary summary = (WUDailySummary) newState.get("daily_summary").getData();

        System.out.println("Standard output listener");

        System.out.println(summary.getMaxHumidity());
        System.out.println(summary.getMaxTempC());
        System.out.println(summary.getMinTempC());
        System.out.println(summary.getPrecipitationM());
    }
}
