package bg.challenge.store;

import bg.challenge.action.Action;


public interface Store {
    public void dispatch(Action action);
    public void subscribe(StoreSubscriber subscriber);
    public State getState();
}
