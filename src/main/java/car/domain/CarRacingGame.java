package car.domain;

import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.domain.winnerstrategy.WinnerStrategy;
import utils.random.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy;
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private int leftPlayCount;

    public CarRacingGame(final List<String> carNames, final int playCount) {
        this(carNames, playCount, new MaxPositionDuplicateWinnerStrategy());
    }

    public CarRacingGame(final List<String> carNames, final int playCount, final WinnerStrategy winnerStrategy) {
        this.cars = new Cars(carNames);
        validatePositive(playCount);
        this.leftPlayCount = playCount;
        this.winnerStrategy = winnerStrategy;
    }

    public void playRaceOnce() {
        if (isFinished()) {
            throw new IllegalStateException("남은 실행 횟수가 0이므로 더 이상 실행할 수 없습니다.");
        }

        cars.move(randomGenerator);
        leftPlayCount--;
    }

    public List<String> formatCars(final CarFormatter formatter) {
        return cars.format(formatter);
    }

    public List<Name> resolveWinnerNames() {
        return selectWinnersFromCars().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public boolean isNotFinished() {
        return leftPlayCount > 0;
    }

    private boolean isFinished() {
        return leftPlayCount == 0;
    }

    private void validatePositive(final int playCount) {
        if (playCount <= 0) {
            throw new IllegalArgumentException(String.format("실행 횟수는 양수여야 합니다. 입력한 데이터 : %d", playCount));
        }
    }

    private List<Car> selectWinnersFromCars() {
        return cars.selectWinners(winnerStrategy);
    }
}
