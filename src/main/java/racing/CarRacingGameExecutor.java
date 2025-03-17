package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.RandomRacingCarMovingStrategy;
import racing.types.RacingCarCount;
import racing.types.SimulateCount;
import racing.util.InputView;
import racing.util.OutputView;

import java.util.List;

public class CarRacingGameExecutor {

  public static void main(String[] args) {
    RacingCarCount racingCarCount = getCarCount();
    SimulateCount simulateCount = getSimulateCount();

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(racingCarCount, new RandomRacingCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    printSimulationResult(simulator.run(simulateCount));

  }

  private static RacingCarCount getCarCount() {
    int carCount = InputView.showCarCountInput();
    return new RacingCarCount(carCount);
  }

  private static SimulateCount getSimulateCount() {
    int simulateCount = InputView.showSimulateCountInput();
    return new SimulateCount(simulateCount);
  }

  private static void printSimulationResult(List<List<Integer>> simulationResults) {
    simulationResults.forEach(roundResult -> {
      OutputView.showLocation(roundResult);
      OutputView.showWhitespace();
    });
  }
}
