package racing.view;

import racing.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void showCarsProcess(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.getName() + ":" + car.getDistance()));
        System.out.println();
    }

    public static void showWinner(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().getAsInt();

        String winner = cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(","));
        System.out.print(winner + "가 우승하셨습니다.");


    }
}
