package racingcar.view;

import racingcar.application.RaceService;
import racingcar.domain.Car;

import java.util.List;

public class ResultView {

    public static void startAndDisplay(List<Car> cars, int tryCount) {
        System.out.println("실행 결과");
        for (int count = 0; count < tryCount; count++) {
            RaceService.startRace(cars);
            displayRace(cars);
        }
    }

    public static void displayRace(List<Car> cars) {
        cars.forEach(car -> System.out.println("-".repeat(car.getPosition())));
        System.out.println();
    }
}
