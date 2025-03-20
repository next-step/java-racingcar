package racingcar.io;

import java.util.List;

import racingcar.domain.CarPositions;
import racingcar.domain.CarSimulator;

public class OutputView {
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
        List<Integer> positions = carPositions.getPositions();

        for (int position : positions) {
            System.out.println("-".repeat(position));
        }

        System.out.println();
    }

}
