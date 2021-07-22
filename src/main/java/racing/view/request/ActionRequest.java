package racing.view.request;

import racing.view.InputAction;

public class ActionRequest {
    private final InputAction action;
    private final int turnSize;

    public ActionRequest(InputAction action, int turnSize) {
        this.action = action;
        this.turnSize = turnSize;
    }

    public InputAction getAction() {
        return action;
    }

    public int getTurnSize() {
        return turnSize;
    }
}
