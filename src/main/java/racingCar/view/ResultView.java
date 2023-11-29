package racingCar.view;

import java.util.ArrayList;
import java.util.List;

import racingCar.domain.Car;
import racingCar.domain.Cars;

public class ResultView {

    public static void executionResultSign() {
        System.out.println("실행 결과");
    }

    public static void showDistance(Cars cars) {
        for (Car car : cars.allCar()) {
            System.out.println(car.carName().getValue() + " : " + "-".repeat(car.distance().getValue()));
        }
    }

    public static void showNextRound() {
        System.out.println();
    }

    public static void announceWinner(List<Car> cars) {System.out.println(carNamesString(cars) + "가 최종 우승했습니다.");}

    private static String carNamesString(List<Car> cars) {
        List<String> carNameList = new ArrayList<>();
        for (Car car : cars) {
            carNameList.add(car.carName().getValue());
        }

        return String.join(",", carNameList);
    }

}
