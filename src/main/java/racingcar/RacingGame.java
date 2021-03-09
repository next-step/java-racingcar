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

  private Cars cars;
  private Rule rule;

  public static void main(String[] args) throws IOException {
    RacingGame racingGame = new RacingGame();
    racingGame.initPhase();
    racingGame.playGame();
  }

  public void initPhase() throws IOException {
    int numberOfCars = Integer.parseInt(inputView.getNumberOfCars());
    int numberOfRounds = Integer.parseInt(inputView.getRound());
    createCars(numberOfCars);
    createRule(numberOfRounds, cars);
  }

  public void playGame() {
    outputView.printInitialCarPosition(cars);
    for(int i = 0; i < rule.getRound(); i++){
      rule.doRacing();
      outputView.printCarPosition(cars, i+1);
    }
    outputView.endGame();
  }

  private void createCars(int numberOfCars) {
    List<Car> carList = new ArrayList<>();
    for(int i = 0; i < numberOfCars; i++) {
      carList.add(Car.createCar());
    }
    cars = new Cars(carList);
  }

  private void createRule(int numberOfRounds, Cars cars) {
    rule = Rule.createRule(numberOfRounds, cars);
  }
}
