package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.CarsFormatter;
import car.domain.Name;
import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.domain.winnerstrategy.WinnerStrategy;
import car.view.DefaultCarsFormatter;
import java.util.List;
import java.util.stream.Collectors;
import utils.random.RandomGenerator;

public class CarRacingGame {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
    private final CarsFormatter formatter = new DefaultCarsFormatter();


    public CarRacingGame(final String carNames) {
        cars = new Cars(carNames);
    }

    public void playRace(final int playCount) {
        final RandomGenerator randomGenerator = new RandomGenerator();

        System.out.println("\n실행 결과");
        for (int i = 0; i < playCount; i++) {
            cars.move(randomGenerator);
            cars.print(formatter);
        }
    }

    public List<Name> announceWinnerNames() {
        final List<Car> winners = cars.selectWinners(winnerStrategy);
        return winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
    }
}
