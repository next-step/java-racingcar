package study.racingcar.domain;

import java.util.List;

public class RacingGameResult {
    private GameEvent gameEvent;
    private Cars winners;

    public RacingGameResult(List<Cars> gameEvent) {
        this.gameEvent = new GameEvent(gameEvent);
        setWinners();
    }

    public void addGameEvent(Cars cars) {
        gameEvent.add(cars);
    }

    public Cars getWinners() {
        return new Cars(winners);
    }

    public GameEvent getGameEvent() {
        return new GameEvent(gameEvent);
    }

    private void setWinners() {
        Cars cars = gameEvent.getLastEvent();
        int maxPosition = cars.getMaxPosition();
        winners = cars.getByPosition(maxPosition);
    }
}
