package racingGame;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final TryNumber tryNumber;
    private final MoveStrategy strategy;

    private int playedCount = 0;
    public RacingGame(String carNames, int tryNo) {
        this(Util.parseNames(carNames), new TryNumber(tryNo), new RandomMoveStrategy());
    }

    public RacingGame(List<String> names, int tryNo, MoveStrategy strategy) {
        this(Util.parseNamesFromList(names), new TryNumber(tryNo), strategy);
    }

    private RacingGame(List<String> names, TryNumber tryNumber, MoveStrategy strategy) {
        this.cars = Cars.fromNames(names);
        this.tryNumber = tryNumber;
        this.strategy = strategy;
    }
    public boolean isEnd() {
        return tryNumber.canPlayMore(playedCount);
    }
    public void race() {
        cars.moveAll(strategy);
        playedCount++;
    }
    public List<Car> getCars() {
        return cars.asList();
    }
    public List<String> findWinners() {
        return cars.winnerNames();
    }
    static class Util {
        static List<String> parseNames(String carNames) {
            return java.util.Arrays.stream(carNames.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
        }

        static List<String> parseNamesFromList(List<String> names) {
            return names.stream()
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
        }
    }
}
