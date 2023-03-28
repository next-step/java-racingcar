package racingcar.view;

import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String REPRESENTATION_FLAG = "-";

    public static void printCars(Cars cars) {
        cars.getCars().forEach(car ->
            System.out.println(car.getName() + " : " + REPRESENTATION_FLAG.repeat(car.getPosition()))
        );
    }

    public static void showWinner(Cars cars) {
        List<String> winnerNames = new ArrayList<>();
        cars.getCars().forEach(car -> winnerNames.add(car.getName()));
        System.out.println("최종 우승자 : " + String.join(",", winnerNames));
    }
}
