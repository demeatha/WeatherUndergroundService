package bg.challenge.store;

import bg.challenge.action.Payload;

import java.util.Map;

public class MapState implements State<Map<String,Payload>> {
    private Map<String, Payload> data;

    public MapState(Map<String, Payload> data) {
        this.data = data;
    }

    @Override
    public Map<String, Payload> current() {
        return this.data;
    }
}
