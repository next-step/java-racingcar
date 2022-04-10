package racingcar.view;

import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    public static void outputMoveCar(Cars cars, int carMoveCount) {
        for (int i = 0; i < carMoveCount; i++) {
            cars.move();
            outputPosition(cars);
            outputEmptyLine();
        }
    }

    private OutputView() throws InstantiationException {
        throw new InstantiationException();
    }

    private static void outputPosition(Cars cars) {
        List<Integer> allPositions = cars.getAllPositions();
        allPositions.forEach(OutputView::outputPosition);
    }

    private static void outputPosition(int position) {
        for (int j = 0; j < position; j++) {
            System.out.print("-");
        }

        outputEmptyLine();
    }

    private static void outputEmptyLine() {
        System.out.println();
    }
}
