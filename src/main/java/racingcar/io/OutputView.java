package racingcar.io;

import java.util.List;

import racingcar.domain.CarPosition;
import racingcar.domain.CarPositions;
import racingcar.domain.CarSimulator;

public class OutputView {
    public static final String COLON = " : ";
    public static final String MOVE = "-";

    private final CarSimulator simulator;

    public OutputView(CarSimulator simulator) {
        this.simulator = simulator;
    }

    public void printPositions() {
        List<CarPositions> history = simulator.getHistory();

        System.out.println("실행 결과");

        for (CarPositions carPositions : history) {
            printPosition(carPositions);
        }
    }

    public void printPosition(CarPositions carPositions) {
        List<CarPosition> positions = carPositions.getPositions();

        for (CarPosition position : positions) {
            System.out.println(printResult(position));
        }

        System.out.println();
    }

    private String printResult(CarPosition position) {
        return position.getName() + COLON + MOVE.repeat(position.getPosition());
    }

}
