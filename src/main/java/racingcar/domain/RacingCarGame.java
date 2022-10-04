package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private final Cars cars;
    private int playCount;

    public RacingCarGame(String[] carNames, int playCount) {
        this.cars = new Cars(carNames);
        this.playCount = playCount;
    }

    public static List<PlayResult> findWinners(List<PlayResult> playResults) {
        return findWinners(playResults, getMaxPosition(playResults));
    }

    private static List<PlayResult> findWinners(List<PlayResult> playResults, Position maxPosition) {
        return playResults.stream()
                .filter(playResult -> playResult.isPositionEquals(maxPosition))
                .collect(Collectors.toList());
    }

    private static Position getMaxPosition(List<PlayResult> playResults) {
        return playResults.stream().max(Comparator.comparing(PlayResult::getPosition))
                .map(PlayResult::getPosition)
                .orElse(new Position(0));
    }

    public void play(MovingStrategy movingStrategy) {
        playCount--;
        cars.move(movingStrategy);
    }

    public List<PlayResult> getPlayResults() {
        return cars.getPlayResults();
    }

    public boolean isEnd() {
        return playCount <= 0;
    }
}
