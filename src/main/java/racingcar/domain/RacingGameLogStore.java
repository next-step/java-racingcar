package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameLogStore {

    private final List<RacingGameLog> logs = new ArrayList<>();

    public void store(RacingGame racingGame) {
        this.logs.add(new RacingGameLog(new RacingCars(racingGame.getRacingCars())));
    }

    public List<RacingGameLog> getLogs() {
        return Collections.unmodifiableList(logs);
    }
}
