package step3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testutils.IOTest;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.*;

public class CarRepositoryTest {
  private final CarRepository carRepository = new CarRepository();

  @ParameterizedTest
  @CsvSource(value = { "1:1", "2:2", "5:5" }, delimiter = ':')
  void 자동차_추가_기본(int repetition, int expected) {

    for (int i = 0; i < repetition; i++) {
      System.out.println("i: " + i);
      carRepository.addEmptyCar();
    }

    /*
    기본적으로 assert 문을 하나만 사용하는 것이 권장된다는 것을 알지만,
    어떤 검증 방법이 가장 나을지 리뷰를 받고자 세 가지 assert 문을 사용하였습니다.
    */
    assertThat(carRepository.containsCarWithLocationOf(0)).isTrue();
    assertThat(carRepository.size()).isEqualTo(expected);

    assertThat(carRepository.sizeOfCarsWithLocationOf(0)).isEqualTo(expected);
  }

  @Test
  void 자동차_추가_자동차_객체() {
    carRepository.addCar(new Car());
    carRepository.addCar(new Car(10));

    assertThat(carRepository.getNumberOfCars()).isEqualTo(2);
  }

  @Test
  void 자동차_추가_자동차_개수() {
    carRepository.addCars(5);

    assertThat(carRepository.getNumberOfCars()).isEqualTo(5);
  }
}
