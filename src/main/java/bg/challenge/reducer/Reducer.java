package bg.challenge.reducer;

import bg.challenge.action.Action;
import bg.challenge.store.Store;


public interface Reducer<T> {
    public T update(Action action, Store store);
}
