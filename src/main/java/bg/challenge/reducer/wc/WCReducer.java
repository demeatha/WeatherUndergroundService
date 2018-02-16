package bg.challenge.reducer.wc;

import bg.challenge.action.Action;
import bg.challenge.action.wu.WUActionType;
import bg.challenge.model.wu.WUDailySummary;
import bg.challenge.reducer.Reducer;
import bg.challenge.action.Payload;
import bg.challenge.store.Store;

import java.util.HashMap;
import java.util.Map;


public class WCReducer implements Reducer<Map<String,Payload>> {

    @Override
    public Map<String,Payload> update(Action action, Store store) {
        if (action == null) {
            return (Map<String, Payload>) store.getState().current();
        }

        switch ((WUActionType)action.getActionType()) {
            case FETCH_DAILY_SUMMARY:
                Payload<WUDailySummary> payload = (Payload<WUDailySummary>) action.getPayload();
                Map<String, Payload> state = new HashMap<String, Payload>();
                state.put("daily_summary", payload);
                return state;
            default:
                return (Map<String, Payload>) store.getState().current();
        }
    }
}
