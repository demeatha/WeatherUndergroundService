package bg.challenge.store;

import bg.challenge.action.Action;
import bg.challenge.action.Payload;
import bg.challenge.reducer.Reducer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStore implements Store {
    private static MapStore instance;
    private Map <String, Payload> state;
    private List<StoreSubscriber> subscribers;
    private List<Reducer> reducers;


    private MapStore() {
        this.state = new HashMap<String, Payload>();
        this.subscribers = new ArrayList<StoreSubscriber>();
    }

    public static Store init() {
        if (MapStore.instance == null) {
            MapStore.instance = new MapStore();
        }
        MapStore.updateStore(MapStore.instance.reducers, null);
        return MapStore.instance;
    }

    public static Store init(List<Reducer> reducers) {
        if (MapStore.instance == null) {
            MapStore.instance = new MapStore();
        }
        MapStore.instance.reducers = reducers;
        MapStore.updateStore(reducers, null);
        return MapStore.instance;
    }

    @Override
    public void dispatch(Action action) {
        this.updateStore(reducers, action);
        for(StoreSubscriber s : this.subscribers) {
            s.onUpdate(new MapState(state));
        }
    }

    @Override
    public void subscribe(StoreSubscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public State getState() {
        return new MapState(state);
    }

    private static void updateStore(List<Reducer> reducers, Action action) {
        for(Reducer r : reducers) {
            Map<String,Payload> partialState = (Map<String, Payload>) r.update(action, MapStore.instance);
            if (partialState != null) {
                partialState.forEach((k, v) -> MapStore.instance.state.put(k, v));
            }
        }
    }
}
