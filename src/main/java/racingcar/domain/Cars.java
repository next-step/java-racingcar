package racingcar.domain;

<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
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
      car.moveCar(randomNumberGenerator.generateRandomNumber());
    }
  }

  public String currentCarsPosition() {
    StringBuilder sb = new StringBuilder();
    for(Car car : cars) {
<<<<<<< HEAD
     sb.append(car.printNameWithCurrentPosition()).append("\n");
    }
    return sb.toString();
  }

  public List<String> getWinner() {
    List<String> winnerNames = new ArrayList<>();

    getWinnerNames(winnerNames, getMaxPositionInCars());

    return winnerNames;
  }

  private void getWinnerNames(List<String> winnerNames, int max) {
    for(Car car : cars) {
      if(car.getPosition() == max) {
        winnerNames.add(car.getName());
      }
    }
  }

  private int getMaxPositionInCars() {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max().orElseThrow(IllegalArgumentException::new);
  }
=======
      sb.append(car.positionToLine()).append("\n");
    }
    return sb.toString();
  }
>>>>>>> 6e976b58 ([자동차 경주 3단계] 구현 완료하여 리뷰 요청 드립니다!! (#1997))
}
