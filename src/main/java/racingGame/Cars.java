package racingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import javafx.util.Pair;

public class Cars {

  private final List<Car> cars;

  private Cars(List<Car> cars) {
    this.cars = cars;
  }

  public static Cars of(List<String> names) {
    validateInput(names);

    return new Cars(createCarsWithNames(names));
  }

  private static List<Car> createCarsWithNames(List<String> names) {
    List<Car> cars = new Vector<>();

    for (String name : names) {
      cars.add(Car.of(name));
    }

    return cars;
  }

  private static void validateInput(List<String> names) {
    if (names == null) {
      throw new IllegalArgumentException();
    }
  }

  public static Cars of(String rawInput) {
    return of(parseRawInput(rawInput));
  }

  private static List<String> parseRawInput(String rawInput) {
    validateRawInput(rawInput);

    return new Vector<>(Arrays.asList(rawInput.split(",")));
  }

  private static void validateRawInput(String rawInput) {
    if (rawInput == null || rawInput.length() < 1) {
      throw new IllegalArgumentException();
    }
  }

  public void movesCar(ScoreGenerator scoreGenerator){
    for (Car car : this.cars){
      car.move(scoreGenerator);
    }
  }

  public int extractFurthestPosition() {
    int furthestPosition = 0;

    for (Car car : this.cars) {
      furthestPosition = car.renewWinner(furthestPosition);
    }

    return furthestPosition;
  }

  public List<String> extractWinners(int furthestPosition) {
    List<String> winners = new Vector<>();
    for (Car car : this.cars) {
      addWinnerName(furthestPosition, winners, car);
    }
    return winners;
  }

  private void addWinnerName(int furthestPosition, List<String> winners, Car car) {
    if (car.isWinner(furthestPosition)) {
      winners.add(car.getName());
    }
  }

  List<Pair<String, Integer>> getCarsStatus() {
    List<Pair<String, Integer>> status = new Vector<>();

    for (Car car : this.cars) {
      status.add(car.publishNamePosition());
    }
    return status;
  }
}
