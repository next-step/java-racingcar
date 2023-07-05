package racingcar.car;

import racingcar.car.domain.Car;
import racingcar.car.domain.Cars;
import racingcar.car.domain.winnerstrategy.MaxPositionDuplicateWinnerStrategy;
import racingcar.car.domain.winnerstrategy.WinnerStrategy;
import racingcar.car.ui.CarFormatter;
import racingcar.car.ui.DefaultCarFormatter;
import java.util.List;
import java.util.stream.Collectors;

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
