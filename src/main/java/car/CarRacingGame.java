package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.CarsFormatter;
import car.domain.Name;
import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.domain.winnerstrategy.WinnerStrategy;
import java.util.List;
import java.util.stream.Collectors;
import utils.random.RandomGenerator;

public class CarRacingGame {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
    private final RandomGenerator randomGenerator = new RandomGenerator();
    private int leftPlayCount;

    public CarRacingGame(final String carNames, final int playCount) {
        this.cars = new Cars(carNames);
        this.leftPlayCount = playCount;
    }

    public void playRaceOnce() {
        cars.move(randomGenerator);
        leftPlayCount--;
    }

    public String formatCurrentRaceStatus(CarsFormatter formatter) {
        return cars.format(formatter);
    }

    public boolean isNotFinished() {
        return leftPlayCount > 0;
    }

    public List<Name> resolveWinnerNames() {
        final List<Car> winners = cars.selectWinners(winnerStrategy);
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
