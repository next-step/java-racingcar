package racingcar.view;

import racingcar.factory.CarsFactory;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public void outputMoveCar(int carCount, int carMoveCount) {
        Cars cars = CarsFactory.create(carCount);

        for (int i = 0; i < carMoveCount; i++) {
            outputMove(cars);
            outputEmptyLine();
        }
    }

    private void outputMove(Cars cars) {
        cars.move();
        outputPosition(cars);
    }

    private void outputPosition(Cars cars) {
        List<Integer> allPositions = cars.getAllPositions();
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
