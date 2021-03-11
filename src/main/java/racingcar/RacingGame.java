package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  private static final InputView inputView = new InputView(reader);
  private static final OutputView outputView = new OutputView();

  private int round;
  private Cars cars;
  private RandomNumberGenerator randomNumberGenerator;

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
    outputView.printInitialCarPosition(cars);
    doRacingGame();
    outputView.endGame();
  }

  private void doRacingGame() {
    for(int i = 0; i < round; i++){
      cars.updateAll(randomNumberGenerator);
      outputView.printCarPosition(cars, i+1);
    }
  }

  private void initPhase(int numberOfCar, int numberOfRound) {
    this.cars = createCars(numberOfCar);
    this.round = numberOfRound;
    this.randomNumberGenerator = new RandomNumberGenerator(System.currentTimeMillis());
  }

  private Cars createCars(int numberOfCars) {
    List<Car> carList = new ArrayList<>();
    for(int i = 0; i < numberOfCars; i++) {
      carList.add(Car.createCar());
    }
    return new Cars(carList);
  }
}
