package bg.challenge.store;


public interface StoreSubscriber {
    public void onUpdate(State state);
}
