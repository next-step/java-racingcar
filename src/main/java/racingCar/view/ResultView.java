package racingCar.view;

import racingCar.domain.Car;
import racingCar.domain.Winners;

import java.util.List;

public class ResultView {
    public static void show(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
    public static void showWinner(Winners winners) {
        System.out.println(String.join(", ", winners.getNames()) + "가 최종 우승했습니다.");
    }

}
