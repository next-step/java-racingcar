package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String REPRESENTATION_FLAG = "-";

    public static void printCars(List<Car> cars) {
        cars.forEach(car ->
            System.out.println(car.getName() + " : " + REPRESENTATION_FLAG.repeat(car.getPosition()))
        );
    }

    public static void showWinner(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>();
        cars.forEach(car -> winnerNames.add(car.getName()));
        System.out.println("최종 우승자 : " + String.join(",", winnerNames));
    }
}
