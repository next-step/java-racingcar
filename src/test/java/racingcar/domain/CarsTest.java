package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.*;

public class CarsTest {
  private final Cars cars = new Cars();

  @ParameterizedTest
  @CsvSource(value = { "1:1", "2:2", "5:5" }, delimiter = ':')
  void 자동차_추가_기본(int numberOfCars) {
    cars.addEmptyCars(numberOfCars);
    // 거리가 0 보다 더 먼 Car는 없다는 것을 테스트
    assertThat(cars.hasCarFurtherThan(new Car(0))).isFalse();
  }

  @Test
  void 자동차_추가_자동차_객체() {
    cars.addCar(new Car());
    cars.addCar(new Car(10));

    assertThat(cars.size()).isEqualTo(2);
  }

  @Test
  void 자동차_추가_자동차_개수() {
    cars.addEmptyCars(5);

    assertThat(cars.size()).isEqualTo(5);
  }

  @Test
    void 가장_앞선_자동차_목록1() {
      cars.addCar(new Car("test1", 3));
      cars.addCar(new Car("test2", 4));
      cars.addCar(new Car("test3", 3));
      cars.addCar(new Car("test4", 5));
      cars.addCar(new Car("test5", 5));

      assertThat(cars.leadingCars().size()).isEqualTo(2);
  }

  @Test
  void 가장_앞선_자동차_목록2() {
    cars.addCar(new Car("test1", 3));
    cars.addCar(new Car("test2", 5));
    cars.addCar(new Car("test3", 3));
    cars.addCar(new Car("test4", 5));

    for (Car car : cars.leadingCars()) {
      System.out.println("car: " + car);
    }

    assertThat(cars.leadingCars())
            .containsExactly(new Car("test2", 5), new Car("test4", 5));
  }

  @Test
  void 입력된_조건값_목록에_따라_자동차_모두_이동() {
    cars.addEmptyCars(5);
    cars.moveAllCars(new int[] { 2, 3, 4, 5, 6 });

    assertThat(cars.numberOfCarsWithLocationOf(1)).isEqualTo(3);
  }
}
