package racing;

import racing.simulator.Car;
import racing.simulator.RandomCarMovingStrategy;
import racing.simulator.CarRacingGameSimulator;
import racing.util.InputValidator;
import racing.util.InputView;
import racing.util.OutputView;

import java.util.List;

public class CarRacingGameExecutor {

  public static void main(String[] args) {
    int carCount = getCarCount();
    int simulateCount = getSimulateCount();

    CarRacingGameSimulator simulator = new CarRacingGameSimulator(carCount, new RandomCarMovingStrategy());

    OutputView.showWhitespace();
    OutputView.showExecutionResultText();
    printSimulationResult(simulator.run(simulateCount));

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

  private static void printSimulationResult(List<List<Car>> simulationResults) {
    simulationResults.forEach(roundResult -> {
      OutputView.showCarsLocation(roundResult);
      OutputView.showWhitespace();
    });
  }
}
