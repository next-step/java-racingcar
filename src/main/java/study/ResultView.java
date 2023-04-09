package study;

import java.util.List;

import static java.lang.System.out;

public class ResultView {
    public static void raceStart() {
        out.println("실행 결과");
    }

    public static void displayCarLocation(Car car) {
        for (int j = 0; j < car.getCurrentLocation(); j++) {
            out.print("-");
        }
        out.println();
    }

    public static void displayCars(List<Car> cars) {
        for (Car car : cars) {
            ResultView.displayCarLocation(car);
        }
        out.println();
    }
}
