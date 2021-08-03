package racingcar.view;

import racingcar.car.Car;
import racingcar.car.Cars;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {

    private static final StringBuilder carStatusString = new StringBuilder();
    private static final StringJoiner winnerCarsNameString = new StringJoiner(",");

    public static void printResultTitle() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printEachRacing(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private static void printCarStatus(Car car) {
        carStatusString.setLength(0);
        carStatusString.append(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            carStatusString.append("-");
        }
        System.out.println(carStatusString);
    }

    public static void printWinnerCars(List<Car> winners) {
        for (Car car : winners) {
            winnerCarsNameString.add(car.getName());
        }
        System.out.println(winnerCarsNameString + "가 최종 우승했습니다.");
    }


}
