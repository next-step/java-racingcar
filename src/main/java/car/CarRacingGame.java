package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.domain.winnerstrategy.WinnerStrategy;
import car.ui.CarFormatter;
import car.ui.DefaultCarFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final Cars cars;
    private final WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
    private final CarFormatter formatter = new DefaultCarFormatter();


    public CarRacingGame(final String carNames) {
        cars = new Cars(carNames);
    }

    public void play(final int playCount) {
        race(playCount);
        printWinners();
    }

    private void race(final int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.move();
            cars.print(formatter);
        }
    }

    private void printWinners() {
        final List<Car> winners = cars.getWinners(winnerStrategy);
        final String winnerNames = winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
