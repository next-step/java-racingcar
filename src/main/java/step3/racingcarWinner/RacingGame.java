package step3.racingcarWinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

  private static String inputName;
  private static int inputTryCount;
  private static int DEFAULT_CAR_LOCATION = 0;
  private static final int RANDOM_BOUND = 10;
  private static final int MOVE_MIN_VALUE = 4;
  private static final String SPLIT_REGX = ",";
  private int maxPosition;

  public RacingGame(String inputName, int inputTryCount) {
    this.inputName = inputName;
    this.inputTryCount = inputTryCount;
  }

  public String[] parseCarNameArr(String inputName) {
    return inputName.split(SPLIT_REGX);
  }

  public boolean isMove(int arg) {
    if (arg >= MOVE_MIN_VALUE) {
      return true;
    }
    return false;
  }

  private int getRandomNo() {
    Random random = new Random();
    return random.nextInt(RANDOM_BOUND);
  }

  public List<Car> start() {
    String[] carNameArr = parseCarNameArr(inputName);
    List<Car> carList = createCarList(carNameArr);
    return race(carList, inputTryCount);
  }

  private List<Car> race(List<Car> carList, int inputTryCount) {
    for (int i = 0; i < inputTryCount; i++) {
      moveCarList(carList);
    }
    prize(carList);
    return carList;
  }

  private void prize(List<Car> carList) {
    for (Car car : carList) {
      prizePerCar(car);
    }
  }

  private void prizePerCar(Car car) {
    if(isWinner(car)){
      car.prizeWinner();
    }
  }

  private boolean isWinner(Car car) {
    if(car.getPosition() == maxPosition){
      return true;
    }
    return false;
  }

  private List<Car> moveCarList(List<Car> carList) {
    for (Car car : carList) {
      moveCar(car);
    }
    System.out.println("");
    return carList;
  }

  private void moveCar(Car car) {
    if (isMove(getRandomNo())) {
      car.move();
    }
    if (maxPosition < car.getPosition()) {
      maxPosition = car.getPosition();
    }
    ResultView.printCurrentCarPosition(car);
  }

  public List<Car> createCarList(String[] carNameArr) {
    List<Car> carList = new ArrayList<>();
    for (String carName : carNameArr) {
      carList.add(new Car(carName, DEFAULT_CAR_LOCATION));
    }
    return carList;
  }

}
