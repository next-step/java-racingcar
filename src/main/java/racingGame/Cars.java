package racingGame;

import java.util.List;
import java.util.Vector;

public class Cars {

  /**
   * 게임에 사용되는 Car 들을 List<Car>의 형태로 가지고 있는 객체. 게임에 사용되는 Car 전체의 상태와 각각의 Car에 접근 가능하게 함
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

  // Car가 어떻게 움직일 지 만드는 기능.
  // 아.. Car의 position 상태 변경에 영향을 줌.
  // 심지어 외부 Game Client에서 받아서 사용하고 있음
  // position을 변경하려면 3군대에서 고쳐야 됨. 일단은 Cars 안으로만..
  // 이후 Car 객체 생성할 때 move를 어떻게 할지 지정하는 것으로 하면 될 듯
  // Car가 알아서 움직이게 해야됨
  public void moves() {
    ScoreGenerator scoreGenerator = new RandomScoreGenerator();
    for (Car car : cars) {
      car.move(scoreGenerator.generateScore());
    }
  }

  public Car get(int index) {
    return cars.get(index);
  }

  public int size() {
    return this.cars.size();
  }
}
