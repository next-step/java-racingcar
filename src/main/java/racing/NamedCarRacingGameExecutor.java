package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.CarRacingGameWinnerSelector;
import racing.types.RacingCar;
import racing.simulator.RandomRacingCarMovingStrategy;
import racing.types.RacingCarName;
import racing.types.SimulateCount;
import racing.util.InputView;
import racing.util.OutputView;
import racing.util.RacingCarNameInputSplitter;

import java.util.List;

public class NamedCarRacingGameExecutor {

  public static void main(String[] args) {
    List<RacingCarName> names = getCarNames() ;
    SimulateCount simulateCount = getSimulateCount();

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(names, new RandomRacingCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    List<List<RacingCar>> simulateResult = simulator.run(simulateCount);
    printSimulationResult(simulateResult);
    printWinner(simulateResult, new CarRacingGameWinnerSelector());
  }

  private static List<RacingCarName> getCarNames() {
    return RacingCarNameInputSplitter.split(InputView.showCarNamesInput());
  }

  private static SimulateCount getSimulateCount() {
    int simulateCount = InputView.showSimulateCountInput();
    return new SimulateCount(simulateCount);
  }

  private static void printSimulationResult(List<List<RacingCar>> simulationResults) {
    simulationResults.forEach(roundResult -> {
      OutputView.showLocation(roundResult);
      OutputView.showWhitespace();
    });
  }

  private static void printWinner(List<List<RacingCar>> simulateResult, CarRacingGameWinnerSelector selector) {
    OutputView.showWinner(selector.select(simulateResult.get(simulateResult.size() - 1)));
  }
}
