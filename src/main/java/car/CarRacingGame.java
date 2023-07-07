package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.Name;
import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.domain.winnerstrategy.WinnerStrategy;
import car.domain.CarsFormatter;
import car.ui.DefaultCarsFormatter;
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

    public void play(final int playCount) {
        race(playCount);
        printWinners();
    }

    private void race(final int count) {
        final RandomGenerator randomGenerator = new RandomGenerator();

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.move(randomGenerator);
            cars.print(formatter);
        }
    }

    private void printWinners() {
        final List<Car> winners = cars.getWinners(winnerStrategy);
        final String winnerNames = winners.stream()
            .map(Car::getName)
            .map(Name::getValue)
            .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
