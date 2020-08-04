package view;

import domain.Car;

import java.util.List;

public class ResultView {
    private static final String LOCATION_SIGN = "-";

    private ResultView() {
    }

    public static void printResultLine() {
        System.out.println("실행 결과");
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
        System.out.println(movement);
    }
}
