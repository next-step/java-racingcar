package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(Names names) {
    cars = new ArrayList<>();
    names.getNames()
        .forEach(name -> cars.add(new Car(name)));
  }

  public int size() {
    return cars.size();
  }

  public Car at(int index) {
    return cars.get(index);
  }

  public void moveAll(RaceEvaluator raceEvaluator) {
    cars.forEach(car -> car.tryMove(raceEvaluator));
  }

  public int findMaxScore() {
    return cars.stream()
        .map(Car::getScore)
        .max(Integer::compare)
        .orElse(0);
  }

  public List<Car> findWinners() {
    int maxScore = findMaxScore();
    return cars.stream()
        .filter(car -> car.isWinner(maxScore))
        .collect(Collectors.toList());
  }
}
