package bg.challenge;


import bg.challenge.action.wu.WUActionCreator;
import bg.challenge.listener.FileWriterDailySummaryListener;
import bg.challenge.reducer.Reducer;
import bg.challenge.reducer.wc.WCReducer;
import bg.challenge.store.MapStore;
import bg.challenge.store.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String [] args) throws InterruptedException {

        // Define reducers
        List<Reducer> reducers = new ArrayList<Reducer>();
        reducers.add(new WCReducer());

        // Initialise store
        Store store = MapStore.init(reducers);

        // subscribe a new file listener
        FileWriterDailySummaryListener fout = new FileWriterDailySummaryListener();
        store.subscribe(fout);

        //dispatch the action that is responsible for fetching daily summary
        store.dispatch(WUActionCreator.fetchWeatherDailySummary(new Date()));

    }

}