package racingcar.view;

import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public void outputMoveCar(Cars cars, int carMoveCount) {
        for (int i = 0; i < carMoveCount; i++) {
            cars.move();
            outputPosition(cars);
            outputEmptyLine();
        }
    }

    private void outputPosition(Cars cars) {
        List<Integer> allPositions = cars.getAllPositions();
        allPositions.forEach(this::outputPosition);
    }

    private void outputPosition(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print("-");
        }

        outputEmptyLine();
    }

    private void outputEmptyLine() {
        System.out.println();
    }
}
