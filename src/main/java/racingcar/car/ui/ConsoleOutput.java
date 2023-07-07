package racingcar.car.ui;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.domain.Car;

public class ConsoleOutput {

    public void printWinners(final List<Car> winners) {
        System.out.println(formatCarWinners(winners) + "가 최종 우승했습니다.");
    }

    public void printResult(String result) {
        System.out.println("\n실행 결과");
        System.out.print(result);
    }

    public String formatCars(final List<Car> cars) {
        StringBuilder sb =  new StringBuilder();
        cars.forEach(car -> sb.append(formatCar(car)).append('\n'));
        sb.append('\n');
        return sb.toString();
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
