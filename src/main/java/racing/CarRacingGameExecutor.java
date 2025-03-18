package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.RandomCarMovingStrategy;
import racing.types.Car;
import racing.types.CarCount;
import racing.types.SimulateCount;
import racing.util.InputView;
import racing.util.OutputView;

import java.util.List;

public class CarRacingGameExecutor {

  public static void main(String[] args) {
    CarCount carCount = getCarCount();
    SimulateCount simulateCount = getSimulateCount();

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new RandomCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    printSimulationResult(simulator.run(simulateCount));

  }

  private static CarCount getCarCount() {
    int carCount = InputView.showCarCountInput();
    return new CarCount(carCount);
  }

  private static SimulateCount getSimulateCount() {
    int simulateCount = InputView.showSimulateCountInput();
    return new SimulateCount(simulateCount);
  }

  private static void printSimulationResult(List<List<Car>> simulationResults) {
    simulationResults.forEach(roundResult -> {
      OutputView.showLocation(roundResult);
      OutputView.showWhitespace();
    });
  }
}
