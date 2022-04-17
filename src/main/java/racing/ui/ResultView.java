package racing.ui;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void printEntireStatus(final List<Cars> snapshots) {
        System.out.println("실행 결과");

        for (Cars cars : snapshots) {
            printRoundStatus(cars);
            System.out.println();
        }
    }

    private static void printRoundStatus(final Cars snapshot) {
        for (Car car : snapshot.getCars()) {
            System.out.print(car.getName() + " : ");
            printCarStatus(car);
            System.out.println();
        }
    }

    private static void printCarStatus(Car car) {
        for (int i = 0, len = car.getDistance(); i < len; i++) {
            System.out.print("-");
        }
    }

    public static void printWinneringCars(final List<Car> winningCars) {
        StringBuffer winningCarsName = new StringBuffer();
        for (Car winningCar : winningCars) {
            winningCarsName.append(winningCar.getName() + ", ");
        }
        winningCarsName.deleteCharAt(winningCarsName.lastIndexOf(", "));

        System.out.println(winningCarsName.toString() + "가 최종 우승했습니다.");
    }
}
