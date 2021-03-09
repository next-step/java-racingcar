package racinggame.view;

import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.Winners;

public class ResultView {

    public static void printCars(Cars cars) {
        for (Car car : cars.cars()) {
            System.out.println(car);
        }
        System.out.println("");
    }

    public static void printWinners(Winners winners) {
        System.out.println(String.format("우승자는 %s 입니다.", winners.winnerNames()));
    }
}
