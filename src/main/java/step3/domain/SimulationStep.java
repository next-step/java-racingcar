package step3.domain;

import java.util.Collections;
import java.util.List;

public class SimulationStep {
    private String stepSnapshot;

    public SimulationStep(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            sb.append(String.join("", Collections.nCopies(cars.get(i).getPosition(), "-")));
            sb.append("\n");
        }
        sb.append("\n");
        this.stepSnapshot = sb.toString();
    }

    public String toString() {
        return stepSnapshot;
    }
}
