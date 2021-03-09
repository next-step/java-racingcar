package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Rule;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingGame {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static final StringBuilder writer = new StringBuilder();

  private static final InputView inputView = new InputView(reader);
  private static final OutputView outputView = new OutputView(writer);

  private Rule rule;

  public static void main(String[] args) throws IOException {
    RacingGame racingGame = new RacingGame();
    racingGame.userInput();
    racingGame.playGame();
  }

  public void userInput() throws IOException {
    int numberOfCar = Integer.parseInt(inputView.getNumberOfCars());
    int numberOfRound = Integer.parseInt(inputView.getRound());
    initPhase(numberOfCar, numberOfRound);
  }

  public void playGame() {
    outputView.printInitialCarPosition(rule.getCars());
    doRacingGame();
    outputView.endGame();
  }

  private void doRacingGame() {
    for(int i = 0; i < rule.getRound(); i++){
      rule.doRacing();
      outputView.printCarPosition(rule.getCars(), i+1);
    }
  }

  private void initPhase(int numberOfCar, int numberOfRound) {
    this.rule = createRule(numberOfRound, createCars(numberOfCar));
  }

  private Cars createCars(int numberOfCars) {
    List<Car> carList = new ArrayList<>();
    for(int i = 0; i < numberOfCars; i++) {
      carList.add(Car.createCar());
    }
    return new Cars(carList);
  }

  private Rule createRule(int numberOfRounds, Cars cars) {
    return Rule.createRule(numberOfRounds, cars);
  }
}
