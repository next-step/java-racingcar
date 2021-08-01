package UI;

import Car.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_INTRO = "실행 결과\n";
    private static final String MOVEMENT = "-";

    public OutputView() {
        System.out.println(RESULT_INTRO);
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            drawMovements(car.getMoveCount());
        }
        System.out.println();
    }

    private void drawMovements(int moveCount) {
        for (int i = 0; i <= moveCount; i++) {
            System.out.print(MOVEMENT);
        }
        System.out.println();
    }

}
