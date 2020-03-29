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
        Cars cars = getLastEvent();
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

    public List<Cars> getGameEvents() {
        List<Cars> clonedGameEvents = new ArrayList<>();

        for (Cars cars : gameEvents) {
            clonedGameEvents.add(cars.clone());
        }

        return clonedGameEvents;
    }

    private Cars getLastEvent() {
        return gameEvents.get(gameEvents.size() - 1);
    }
}
