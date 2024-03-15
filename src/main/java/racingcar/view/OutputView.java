package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String POSITION_DELIMITOR = "-";

    private OutputView() {
        throw new AssertionError();
    }

    public static void printCarsPositionByRounds(List<List<Car>> rounds) {
        System.out.println("실행 결과");

        for (List<Car> cars : rounds) {
            printCarsPositionByOneRound(cars);
        }
        System.out.println();
    }

    public static void printCarsPositionByOneRound(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printCarPosition(int positionNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < positionNumber; i++) {
            stringBuilder.append(POSITION_DELIMITOR);
        }
        System.out.println(stringBuilder);
    }
}
