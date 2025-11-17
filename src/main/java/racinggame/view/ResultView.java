package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Winners;

import java.util.List;

public class ResultView {

    public static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format("%s : %s", car.getName(), "-".repeat(car.getPosition())));
        }
        System.out.println("");
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.format("%s가 최종 우승했습니다.", winners.joinWithComma()));
    }
}
