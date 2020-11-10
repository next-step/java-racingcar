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
    List<Car> cars;

    validateInput(names);

    cars = new Vector<>();

    for (String name : names) {
      cars.add(Car.of(name));
    }

    return new Cars(cars);
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
    if (rawInput == null || rawInput.length() < 1) {
      throw new IllegalArgumentException();
    }

    return new Vector<>(Arrays.asList(rawInput.split(",")));
  }

  // Car 가 어떻게 움직일 지 만드는 기능.
  // 아.. Car 의 position 상태 변경에 영향을 줌.
  // 심지어 외부 Game Client 에서 받아서 사용하고 있음
  // position 을 변경하려면 3군대에서 고쳐야 됨. 일단은 Cars 안으로만..
  // 이후 Car 객체 생성할 때 move 를 어떻게 할지 지정하는 것으로 하면 될 듯
  // 1차 수정: 일단 move 기능 제거 후, RacingOperator 에서 결정하기

  public Car get(int index) {
    return cars.get(index);
  }

  public int size() {
    return this.cars.size();
  }
}
