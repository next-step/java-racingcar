package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class ResultView {
    private static final String LOCATION_SIGN = "-";
    private static final String RESULT_LINE = "실행 결과";
    private static final String WINNER_ALERT = "%s가 최종 우승했습니다.";

    private ResultView() {
    }

    public static void printResultLine() {
        System.out.println(RESULT_LINE);
    }

    public static void printLocations(List<Car> cars) {
        for (Car car : cars) {
            printLocationToSign(car);
        }

        System.out.println();
    }

    public static void printLocationToSign(Car car) {
        String movement = "";

        for (int i = 0; i < car.getLocation(); i++) {
            movement = movement.concat(LOCATION_SIGN);
        }
        System.out.println(car.getPlayer() + " : " + movement);
    }

    public static void printWinners(Cars cars) {
        String winners = cars.getWinners();
        System.out.println(String.format(WINNER_ALERT, winners));
    }
}
