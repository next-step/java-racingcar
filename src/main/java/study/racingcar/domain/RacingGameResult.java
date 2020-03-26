package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private List<Cars> gameEvents;

    public RacingGameResult() {
        gameEvents = new ArrayList<>();
    }

    public void addGameEvent(Cars cars) {
        gameEvents.add(cars);
    }

    public Cars getWinners() {
        Cars cars = gameEvents.get(gameEvents.size() - 1);
        int maxPosition = cars.getMaxPosition();
        return cars.getByPosition(maxPosition);
    }

    public List<Cars> getGameEvents() {
        return gameEvents;
    }
}
