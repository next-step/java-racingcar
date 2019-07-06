package racing.view;

import racing.model.Car;
import racing.model.Cars;

import java.util.stream.Collectors;

public class OutputView {

    public static void showCarsProcess(Cars cars) {
        cars.getCars().forEach(car -> System.out.println(car.getName() + ":" + car.getDistance()));
        System.out.println();
    }

    public static void showWinner(Cars cars) {

        int maxPosition = cars.getMaxPosition();

        String winnersName = cars.getCars().stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.print(winnersName + "가 우승하셨습니다.");
    }
}
