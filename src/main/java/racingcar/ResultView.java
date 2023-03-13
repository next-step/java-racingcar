package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        System.out.println("최종 우승 : " + String.join(
                ", ",
                winners.stream().map(Car::getName).collect(Collectors.toList()))
        );
    }
}
