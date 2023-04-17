package step3.view;

import step3.domain.Car;

import java.util.List;

public class RaceView {

    public static void displayDiscription() {
        System.out.println("실행 결과");
    }

    public static void displayRaceSituation(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println("");
    }

    private static void printCarPosition(Car car) {
        System.out.println("-".repeat(car.getPosition()));
    }
}
