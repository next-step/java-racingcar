package racingcar.ui;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }

    public static void printRaceStart() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printCurrentPosition(List<Car> cars) {
        cars.forEach(OutputView::printCurrentPosition);
        System.out.println();
    }

    private static void printCurrentPosition(Car car) {
        for (int i = 0; i < car.position(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
