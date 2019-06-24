package racingcar.dto;

import racingcar.domain.model.RacingCars;
import racingcar.domain.model.Winners;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    List<RacingCars> snapshot = new ArrayList<>();

    public void addSnapshot(RacingCars racingCars) {
        snapshot.add(racingCars);
    }

    public List<RacingCars> getSnapshot() {
        return new ArrayList<>(snapshot);
    }

    public Winners getWinners() {
        return Winners.of(snapshot.stream().reduce((first, second) -> second).orElse(null).findWinners());
    }
}
