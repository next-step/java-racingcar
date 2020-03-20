package racingcar.dto;

import racingcar.RandomNumGenerator;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String ONE_MOVE = "-";
    private Cars cars;
    private RandomNumGenerator randomNumGenerator;

    public OutputView(Cars cars, RandomNumGenerator randomNumGenerator) {
        this.cars = cars;
        this.randomNumGenerator = randomNumGenerator;
    }

    public void print(int tryCount) {
        System.out.println("실행결과");

        for (int i = 0; i < tryCount; i++) {
            printTryCount(i);
            printCarsAfterMoveOnce();
        }

        printBorderLine();
    }

    private void printTryCount(int currentTryCount) {
        printBorderLine();
        System.out.println("[" + (currentTryCount + 1) + "회차]");
        System.out.println();
    }

    private void printCarsAfterMoveOnce() {
        cars.moveOnce(randomNumGenerator);

        for (Car car : cars.getCars()) {
            System.out.print("출발점 |");
            printPosition(car);
        }
    }

    private void printPosition(Car car) {
        StringBuilder strPosition = new StringBuilder();

        for (int i = 0; i < car.getPosition(); i++) {
            strPosition.append(ONE_MOVE);
        }

        System.out.println(strPosition);
    }

    private void printBorderLine() {
        System.out.println("=====================================");
    }
}
