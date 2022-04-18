package step_3.domain;

import step_3.util.Behavior;
import step_3.util.GameRole;

import java.util.UUID;

public class RacingCar {

    private final String id;

    public RacingCar() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public Behavior stopOrForward(int roundResult) {
        return GameRole.checkRoundResult(roundResult);
    }
}
