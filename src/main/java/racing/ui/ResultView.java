package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void printRoundStatus(final Cars snapshot) {
        for (Car car : snapshot.getCars()) {
            System.out.print(car.getName() + " : ");
            printCarStatus(car);
            System.out.println();
        }
    }

    public static void printEntireStatus(final List<Cars> snapshots) {
        System.out.println("실행 결과");

        for (Cars cars : snapshots) {
            printRoundStatus(cars);
            System.out.println();
        }
    }

    private static void printCarStatus(Car car) {
        for (int i = 0, len = car.getDistance(); i < len; i++) {
            System.out.print("-");
        }
    }
}
