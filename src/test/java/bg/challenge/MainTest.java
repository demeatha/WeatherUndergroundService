package bg.challenge;

import bg.challenge.action.Action;
import bg.challenge.action.Payload;
import bg.challenge.action.wu.WUActionCreator;
import bg.challenge.action.wu.WUActionType;
import bg.challenge.listener.FileWriterDailySummaryListener;
import bg.challenge.listener.StandardOutputDailySummaryListener;
import bg.challenge.model.wu.WUDailySummary;
import bg.challenge.reducer.Reducer;
import bg.challenge.reducer.wc.WCReducer;
import bg.challenge.store.MapStore;
import bg.challenge.store.Store;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainTest {
    @Test
    public void testActionCreationWithValidPayloadData() {
        Action summaryAction = WUActionCreator.fetchWeatherDailySummary(new Date());
        WUDailySummary summary = (WUDailySummary) summaryAction.getPayload().getData();
        System.out.println("Test weather underground service");
        System.out.println(summary.getMaxHumidity());
        System.out.println(summary.getMaxTempC());
        System.out.println(summary.getMinTempC());
        System.out.println(summary.getPrecipitationM());
    }

    @Test
    public void testFluxFlowStoreDispatchStoreSubscribeModulesListen() {
        // Define reducers
        List<Reducer> reducers = new ArrayList<Reducer>();
        reducers.add(new WCReducer());

        // Initialise store
        Store store = MapStore.init(reducers);

        // subscribe a new listener
        StandardOutputDailySummaryListener sout = new StandardOutputDailySummaryListener();
        store.subscribe(sout);

        // Create a dummy action 1
        WUDailySummary summary = new WUDailySummary();
        summary.setMaxHumidity(10);
        summary.setMaxTempC(20);
        summary.setMinTempC(5);
        summary.setPrecipitationM((float) 0.2);
        // Create the payload
        Payload<WUDailySummary> pload = new Payload<WUDailySummary>();
        pload.setData(summary);

        //Create the action
        Action action = new Action();
        action.setType(WUActionType.FETCH_DAILY_SUMMARY);
        action.setPayload(pload);

        //dispatch the first action
        store.dispatch(action);

        // Sleep for 5 secs
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Create a dummy action 2
        summary = new WUDailySummary();
        summary.setMaxHumidity(12);
        summary.setMaxTempC(25);
        summary.setMinTempC(10);
        summary.setPrecipitationM((float) 0.01);
        // Create the payload
        pload = new Payload<WUDailySummary>();
        pload.setData(summary);

        //Create the action
        action = new Action();
        action.setType(WUActionType.FETCH_DAILY_SUMMARY);
        action.setPayload(pload);

        // subscribe a new listener for file
        FileWriterDailySummaryListener fout = new FileWriterDailySummaryListener();
        store.subscribe(fout);

        // dispatch the second action
        store.dispatch(action);
    }
}
