package racingcar.ui;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void viewRacingCar(List<Car> cars) {
        for (Car car : cars) {
            for (int i = 0; i < car.getMoveCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void viewRacingCarWithName(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getMoveCount(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void viewRacingCarWinner(List<String> winners) {
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
