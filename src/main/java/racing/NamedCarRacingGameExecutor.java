package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.RandomCarMovingStrategy;
import racing.types.CarName;
import racing.types.CarRacingGameSimulateResult;
import racing.types.SimulateCount;
import racing.util.CarNameInputSplitter;
import racing.util.InputView;
import racing.util.OutputView;

import java.util.List;

public class NamedCarRacingGameExecutor {

  public static void main(String[] args) {
    List<CarName> names = CarNameInputSplitter.split(InputView.showCarNamesInput());
    SimulateCount simulateCount = SimulateCount.valueOf(InputView.showSimulateCountInput());

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(names, new RandomCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    CarRacingGameSimulateResult simulateResult = simulator.run(simulateCount);
    simulateResult.getSimulationResult().forEach(roundResult -> {
      OutputView.showLocation(roundResult);
      OutputView.showWhitespace();
    });
    OutputView.showWinner(simulateResult.getWinner());
  }
}
