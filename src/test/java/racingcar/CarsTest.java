package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
  private final Cars cars = new Cars();

  @ParameterizedTest
  @CsvSource(value = { "1:1", "2:2", "5:5" }, delimiter = ':')
  void 자동차_추가_기본(int numberOfCars, int expected) {
    cars.addEmptyCars(numberOfCars);
    // 위치가 0인 Car 가 expected 개 있는지 검사
    assertThat(cars.cars()).extracting("location").isEqualTo(listOfZeros(expected));
  }

  private List<Integer> listOfZeros(final int numberOfZeros) {
    final List<Integer> result = new ArrayList<>();
    for (int i = 0; i < numberOfZeros; i++) {
      result.add(0);
    }
    return result;
  }

  @Test
  void 자동차_추가_자동차_객체() {
    cars.addCar(new Car());
    cars.addCar(new Car(10));

    assertThat(cars.getNumberOfCars()).isEqualTo(2);
  }

  @Test
  void 자동차_추가_자동차_개수() {
    cars.addEmptyCars(5);

    assertThat(cars.getNumberOfCars()).isEqualTo(5);
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

    assertThat(cars.leadingCars())
            .extracting("name")
            .extracting("name")
            .containsExactly("test2", "test4");
  }
}
