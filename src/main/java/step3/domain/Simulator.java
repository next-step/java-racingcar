package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private final GameEnvironment gameEnvironment;
    private final Cars cars;
    private List<List<Integer>> records;

    public Simulator(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
        this.cars = gameEnvironment.getCars();
        this.records = new ArrayList<>();
    }

    public void execute() {
        executeSteps();
    }

    private void executeSteps() {
        records = new ArrayList<>();
        for (int i = 0; i < gameEnvironment.getTryCount(); i++) {
            executeStep();
            saveStep();
        }
    }

    private void executeStep() {
        cars.move();
    }

    private void saveStep() {
        records.add(cars.getPositions());
    }

    public List<List<Integer>> getSimulationResult() {
        return records;
    }
}
