package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.RandomCarMovingStrategy;
import racing.types.CarCount;
import racing.types.SimulateCount;
import racing.util.InputView;
import racing.util.OutputView;


public class CarRacingGameExecutor {

  public static void main(String[] args) {
    CarCount carCount = CarCount.valueOf(InputView.showCarCountInput());
    SimulateCount simulateCount = SimulateCount.valueOf(InputView.showSimulateCountInput());

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new RandomCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    simulator.run(simulateCount).getSimulationResult().forEach(roundResult -> {
      OutputView.showLocation(roundResult);
      OutputView.showWhitespace();
    });
  }
}
