package car.view;

import java.util.List;
import java.util.stream.Collectors;

import car.domain.model.Car;
import car.domain.model.Cars;

public class OutputView {

    private static StringBuilder sb;

    public static void printEachRaceResult(final Cars cars) {
        sb = new StringBuilder();
        cars.getCars()
            .forEach(car -> sb.append(car.getName()).append(" : ")
                .append("-".repeat(car.getPosition())).append("\n"));
        System.out.println(sb.toString());
    }

    public static void printWinner(final List<Car> winner) {
        sb = new StringBuilder();
        sb.append(winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(" ")));
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

}
