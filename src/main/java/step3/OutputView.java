package step3;

import java.util.List;

public class OutputView {
    private final CarSimulator simulator;

    public OutputView(CarSimulator simulator) {
        this.simulator = simulator;
    }

    public void printPositions() {
        List<String> positions = simulator.getPositions();

        for (String position : positions) {
            System.out.println(position);
        }
    }
}
