package racing_game.domain;

import racing_game.util.Behavior;
import racing_game.util.GameRole;

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
