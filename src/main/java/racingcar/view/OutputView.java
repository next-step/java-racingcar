package racingcar.view;

import racingcar.model.Cars;
import racingcar.model.factory.CarsFactory;

public class OutputView {
    public void outputMoveCar(int carCount, int carMoveCount) {
        Cars cars = CarsFactory.create(carCount);

        for (int i = 0; i < carMoveCount; i++) {
            cars.move();
            outputPosition(cars);
            outputEmptyLine();
        }
    }

    private void outputPosition(Cars cars) {
        int[] allPositions = cars.getAllPositions();
        for (int position : allPositions) {
            outputPosition(position);
        }
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
