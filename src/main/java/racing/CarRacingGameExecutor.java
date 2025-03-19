package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.RandomCarMovingStrategy;
import racing.types.Car;
import racing.types.CarCount;
import racing.types.CarRacingGameSimulateResult;
import racing.types.SimulateCount;
import racing.util.InputView;
import racing.util.OutputView;

import java.util.List;

public class CarRacingGameExecutor {

  public static void main(String[] args) {
    CarCount carCount = new CarCount(InputView.showCarCountInput());
    SimulateCount simulateCount = new SimulateCount(InputView.showSimulateCountInput());

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new RandomCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    simulator.run(simulateCount).getSimulationResult().forEach(roundResult -> {
      OutputView.showLocation(roundResult);
      OutputView.showWhitespace();
    });
  }
}
