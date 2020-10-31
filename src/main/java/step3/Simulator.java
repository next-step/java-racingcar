package step3;

import java.util.ArrayList;
import java.util.List;

import static step3.RandomGenerator.getLuckyNumber;

public class Simulator {
    private List<SimulationStep> steps;
    private GameEnvironment gameEnvironment;
    private List<Car> cars = new ArrayList<>();

    public Simulator() {
    }

    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
        this.cars = gameEnvironment.getCars();
    }

    public void execute() {
        executeSteps();
    }

    private void executeSteps() {
        steps = new ArrayList<>();
        for (int i = 0; i < gameEnvironment.getTryCount(); i++) {
            executeStep();
            saveStep();
        }
    }

    private void executeStep() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(getLuckyNumber());
        }
    }

    private void saveStep() {
        steps.add(new SimulationStep(cars));
    }

    public List<SimulationStep> getSimulationResult() {
        return steps;
    }
}
