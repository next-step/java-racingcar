package racingGame;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Cars {

  /**
   * 게임에 사용되는 Car 들을 List<Car>의 형태로 가지고 있는 객체. 게임에 사용되는 Car 전체의 상태와 각각의 Car 에 접근 가능하게 함
   */

  private final List<Car> cars;

  private Cars(List<Car> cars) {
    this.cars = cars;
  }

  public static Cars of(List<String> names) {
    validateInput(names);

    List<Car> cars = createCarsWithNames(names);

    return new Cars(cars);
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

  public Car get(int index) {
    return this.cars.get(index);
  }

  public int size() {
    return this.cars.size();
  }
}
