package bg.challenge.action;

public class Action {
    private ActionType actionType;
    private Payload<?> payload;

    public void setType(ActionType type) {
        this.actionType = type;
    }

    public void setPayload(Payload<?> payload) {
        this.payload = payload;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public Payload<?> getPayload() {
        return payload;
    }
}
