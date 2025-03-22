package racing;

import racing.simulator.CarRacingGameSimulator;
import racing.simulator.RandomCarMovingStrategy;
import racing.types.CarCount;
import racing.types.CarRacingGameSimulateResult;
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
    CarRacingGameSimulateResult simulateResult = simulator.run(simulateCount);
    OutputView.showLocation(simulateResult);
    simulator.reset();
  }
}
