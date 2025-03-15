package racing;

import racing.simulator.CarMoveDecider;
import racing.simulator.CarRacingGameSimulator;
import racing.util.InputValidator;
import racing.util.InputView;
import racing.util.OutputView;

import java.util.Random;

public class CarRacingGameExecutor {

  public static void main(String[] args) {
    int carCount = getCarCount();
    int simulateCount = getSimulateCount();

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    execute(carCount, simulateCount);
  }

  private static int getCarCount() {
    int carCount = InputView.showCarCountInput();
    InputValidator.checkNotValidCarCount(carCount);
    return carCount;
  }

  private static int getSimulateCount() {
    int simulateCount = InputView.showSimulateCountInput();
    InputValidator.checkNotValidSimulateCount(simulateCount);
    return simulateCount;
  }

  private static void execute(int carCount, int simulateCount) {
    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new CarMoveDecider(new Random()));
    for (int i = 0; i < simulateCount; i++) {
      simulator.tryMoveCars();
      OutputView.showCarLocation(simulator.copyCars());
      OutputView.showWhitespace();
    }
    simulator.resetCars();
  }
}
