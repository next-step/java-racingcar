package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
  private final Cars cars = new Cars();

  @ParameterizedTest
  @CsvSource(value = { "1:1", "2:2", "5:5" }, delimiter = ':')
  void 자동차_추가_기본(int repetition, int expected) {

    for (int i = 0; i < repetition; i++) {
      System.out.println("i: " + i);
      cars.addEmptyCar();
    }

    /*
    기본적으로 assert 문을 하나만 사용하는 것이 권장된다는 것을 알지만,
    어떤 검증 방법이 가장 나을지 리뷰를 받고자 세 가지 assert 문을 사용하였습니다.
    */
    assertThat(cars.containsCarWithLocationOf(0)).isTrue();
    assertThat(cars.size()).isEqualTo(expected);

    assertThat(cars.sizeOfCarsWithLocationOf(0)).isEqualTo(expected);
  }

  @Test
  void 자동차_추가_자동차_객체() {
    cars.addCar(new Car());
    cars.addCar(new Car(10));

    assertThat(cars.getNumberOfCars()).isEqualTo(2);
  }

  @Test
  void 자동차_추가_자동차_개수() {
    cars.addCars(5);

    assertThat(cars.getNumberOfCars()).isEqualTo(5);
  }

  @Test
  void 가장_앞선_자동차_목록1() {
    cars.addCar(new Car("test1", 5));
    cars.addCar(new Car("test2", 4));
    cars.addCar(new Car("test3", 3));
    cars.addCar(new Car("test4", 5));
    cars.addCar(new Car("test5", 5));

    assertThat(cars.leadingCars().size()).isEqualTo(3);
  }

  @Test
  void 가장_앞선_자동차_목록2() {
    cars.addCar(new Car("test1", 5));
    cars.addCar(new Car("test2", 4));
    cars.addCar(new Car("test3", 3));
    cars.addCar(new Car("test4", 5));

    assertThat(cars.leadingCars())
            .extracting("name")
            .extracting("name")
            .containsExactly("test1", "test4");
  }
}
