
## Key Features
### [flux](https://code-cartoons.com/a-cartoon-guide-to-flux-6157355ab207) pattern
- Action Creators are responsible of creating Action objects that will get stored inside state object
  Actions are consisted of action type, and payload. Action type determines the reducer branch is responsible to process it.
- Reducers are the methods, used to route/filter the payload inside memory.
  Reducers get assigned into store singleton, and based on their implementation will form the global state.
- Store is the Observable singleton that publishes global state to Observers, every time state object changes.
### Request handling
- Request handling takes place inside action creators, where the paylod object gets created
- Jackson deserializer which is applied to DailySummary model fulfills an in depth mapping with requested values.
- The transition from json to Model object gets completed with the integration between Unirest and Jackson.
  ModelMapper is Jackson mapper trivial implementation that is used to integrate both.
### App Properties
- App class read props from resources/app.properties


## Code Example
```java
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

```

## Installation
1. `mvn install`
2. `mvn package`

## Tests
`mvn test`