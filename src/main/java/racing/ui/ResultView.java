package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void print(final Cars snapshot) {
        for (Car car : snapshot.getCars()) {
            for (int i = 0, len = car.getDistance(); i < len; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void print(final List<Cars> snapshots) {
        System.out.println("실행 결과");

        for (Cars cars : snapshots) {
            print(cars);
            System.out.println();
        }
    }
}
