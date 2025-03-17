package step3;

import java.util.List;

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
        List<String> positions = carPositions.getPositions();

        for (String position : positions) {
            System.out.println(position);
        }

        System.out.println();
    }
}
