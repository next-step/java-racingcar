package UI;

import Car.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_INTRO = "실행 결과";
    private static final String MOVEMENT = "-";

    public OutputView() {
        System.out.println(RESULT_INTRO);
    }

    public void printResult(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getCarName()).append(" : -");
            drawMovements(stringBuilder, car.getMoveCount());
        }
        System.out.println(stringBuilder);
    }

    private void drawMovements(StringBuilder stringBuilder,int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            stringBuilder.append(MOVEMENT);
        }
        stringBuilder.append('\n');
    }

}
