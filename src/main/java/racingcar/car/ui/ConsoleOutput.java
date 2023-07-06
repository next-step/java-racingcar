package racingcar.car.ui;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.domain.Car;

public class ConsoleOutput {

    public void printWinners(final List<Car> winners) {
        System.out.println(formatCarWinners(winners) + "가 최종 우승했습니다.");
    }

    public void printCars(final List<Car> cars) {
        cars.forEach(this::printCar);
        System.out.println();
    }

    private void printCar(final Car car) {
        System.out.println(formatCar(car));
    }

    private String formatCarWinners(final List<Car> winners) {
        return winners.stream()
            .map(Car::getNameValue)
            .collect(Collectors.joining(", "));
    }

    private String formatCar(final Car car) {
        return car.getNameValue() + " : " + "-".repeat(car.getPosition());
    }
}
