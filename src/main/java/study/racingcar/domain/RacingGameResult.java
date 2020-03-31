package study.racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private GameEvent gameEvent;
    private Cars winners;
    private List<String> winnerNames;

    public RacingGameResult(List<Cars> gameEvent) {
        this.gameEvent = new GameEvent(gameEvent);
        setWinners();
        setWinnerNames();
    }

    public void addGameEvent(Cars cars) {
        gameEvent.add(cars);
    }

    public Cars getWinners() {
        return new Cars(winners);
    }

    public List<String> getWinnerNames() {
        return new ArrayList<>(winnerNames);
    }

    public GameEvent getGameEvent() {
        return new GameEvent(gameEvent);
    }

    private void setWinners() {
        Cars cars = gameEvent.getLastEvent();
        int maxPosition = cars.getMaxPosition();
        winners = cars.getByPosition(maxPosition);
    }

    private void setWinnerNames() {
        winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
    }
}
