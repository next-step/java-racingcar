package racingcar.domain;


import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomNumberGenerator;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void updateAll(RandomNumberGenerator randomNumberGenerator){
    for(Car car : cars) {
      car.moveCar(new RandomMovingStrategy(randomNumberGenerator));
    }
  }

  public String currentCarsPosition() {
    StringBuilder sb = new StringBuilder();
    for(Car car : cars) {
     sb.append(car.printNameWithCurrentPosition()).append("\n");
    }
    return sb.toString();
  }

  public List<CarName> getWinner() {
    List<CarName> winnerNames = new ArrayList<>();

    getWinnerNames(winnerNames, getMaxPositionInCars());

    return winnerNames;
  }

  private void getWinnerNames(List<CarName> winnerNames, Position max) {
    for(Car car : cars) {
      getMaxPosition(winnerNames, max, car);
    }
  }

  private void getMaxPosition(List<CarName> winnerNames, Position max, Car car) {
    if(car.isWinner(max)) {
      winnerNames.add(car.getName());
    }
  }

  private Position getMaxPositionInCars() {
    Position max = new Position(0);
    for(Car car : cars) {
      max = car.getMaxPosition(max);
    }
    return max;
  }
}
