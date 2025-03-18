package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.CarRacingGameWinnerSelector;
import racing.simulator.RandomRacingCarMovingStrategy;
import racing.types.Car;
import racing.types.CarName;
import racing.types.SimulateCount;
import racing.util.InputView;
import racing.util.OutputView;
import racing.util.CarNameInputSplitter;

import java.util.List;

public class NamedCarRacingGameExecutor {

  public static void main(String[] args) {
    List<CarName> names = getCarNames();
    SimulateCount simulateCount = getSimulateCount();

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(names, new RandomRacingCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    List<List<Car>> simulateResult = simulator.run(simulateCount);
    printSimulationResult(simulateResult);
    printWinner(simulateResult, new CarRacingGameWinnerSelector());
  }

  private static List<CarName> getCarNames() {
    return CarNameInputSplitter.split(InputView.showCarNamesInput());
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

  private static void printWinner(List<List<Car>> simulateResult, CarRacingGameWinnerSelector selector) {
    OutputView.showWinner(selector.select(simulateResult.get(simulateResult.size() - 1)));
  }
}
