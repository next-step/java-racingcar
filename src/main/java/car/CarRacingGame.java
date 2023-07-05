package car;

import car.domain.Car;
import car.domain.Cars;
import car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import car.ui.CarFormatter;
import car.ui.DefaultCarFormatter;
import java.util.List;
import java.util.stream.Collectors;
import car.domain.winnerstrategy.WinnerStrategy;

public class CarRacingGame {

    private Cars cars;
    private WinnerStrategy winnerStrategy = new MaxPositionDuplicateWinnerStrategy();
    private CarFormatter formatter = new DefaultCarFormatter();


    public CarRacingGame(String carNames) {
        cars = new Cars(carNames);
    }

    public void play(int playCount) {
        startRace(playCount);
        printWinners();
    }

    private void startRace(int count) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            cars.move();
            cars.print(formatter);
        }
    }

    private void printWinners() {
        List<Car> winners = cars.getWinners(winnerStrategy);
        String raceResult = winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.joining(", "));
        System.out.println(raceResult + "가 최종 우승했습니다.");
    }
}
