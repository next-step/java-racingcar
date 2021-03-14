package racingcar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
=======
import java.util.List;
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.RandomNumberGenerator;

public class RacingGame {

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
=======

>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
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
<<<<<<< HEAD
    List<String> carNames = inputView.getNameOfCars();
    int numberOfRound = Integer.parseInt(inputView.getRound());
    initPhase(carNames, numberOfRound);
=======
    int numberOfCar = Integer.parseInt(inputView.getNumberOfCars());
    int numberOfRound = Integer.parseInt(inputView.getRound());
    initPhase(numberOfCar, numberOfRound);
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }

  public void playGame() {
    outputView.printInitialCarPosition(cars);
    doRacingGame();
<<<<<<< HEAD
    outputView.endGame(cars);
=======
    outputView.endGame();
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }

  private void doRacingGame() {
    for(int i = 0; i < round; i++){
      cars.updateAll(randomNumberGenerator);
      outputView.printCarPosition(cars, i+1);
    }
  }

<<<<<<< HEAD
  private void initPhase(List<String> carNames, int numberOfRound) {
    this.cars = createCars(carNames);
=======
  private void initPhase(int numberOfCar, int numberOfRound) {
    this.cars = createCars(numberOfCar);
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
    this.round = numberOfRound;
    this.randomNumberGenerator = new RandomNumberGenerator(System.currentTimeMillis());
  }

<<<<<<< HEAD
  private Cars createCars(List<String> carNames) {
    return new Cars(carNames.stream()
        .map(Car::createCar)
        .collect(Collectors.toList()));
=======
  private Cars createCars(int numberOfCars) {
    List<Car> carList = new ArrayList<>();
    for(int i = 0; i < numberOfCars; i++) {
      carList.add(Car.createCar());
    }
    return new Cars(carList);
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
  }
}
