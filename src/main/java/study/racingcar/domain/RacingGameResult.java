package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private GameEvent gameEvent;

    public RacingGameResult(GameEvent gameEvent) {
        this.gameEvent = gameEvent;
    }

    RacingGameResult() {
        gameEvent = new GameEvent();
    }

    public void addGameEvent(Cars cars) {
        gameEvent.add(cars);
    }

    public Cars getWinners() {
        Cars cars = gameEvent.getLastEvent();
        int maxPosition = cars.getMaxPosition();
        return cars.getByPosition(maxPosition);
    }

    public List<String> getWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        Cars winners = getWinners();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        return winnerNames;
    }

    public GameEvent getGameEvent() {
        return new GameEvent(gameEvent);
    }
}
