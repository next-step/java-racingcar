package step3;

import java.util.List;

public class MoveCars {
    private final int turnCount;
    private final int decisionValue;

    public MoveCars(int turnCount, int decisionValue) {
        this.turnCount = turnCount;
        this.decisionValue = decisionValue;
    }

    public void process(MoveCarStatus moveCarStatus, ResultView resultView) {
        for (int i = 0; i < turnCount; i++) {
            moveCar(moveCarStatus.getCars());
            resultView.printResult(moveCarStatus.getCars());
        }
    }

    private void moveCar(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = (int) (Math.random() * 10);
            car.move(randomValue, decisionValue);
        }

    }
}
