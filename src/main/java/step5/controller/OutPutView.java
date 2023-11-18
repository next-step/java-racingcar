package step5.controller;

import step5.domain.Winners;

public class OutPutView {
    public void winnerIs(Winners winners) {
        winners.print(this);
    }
}
