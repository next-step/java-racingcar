package step3;

import org.junit.jupiter.api.Test;
import testutils.IOTest;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.*;

public class CarRepositoryTest {
  private final CarRepository carRepository = new CarRepository();

  @Test
  void 자동차_추가_기본() {
    carRepository.addCar();
    carRepository.addCar();

    assertThat(carRepository.getNumberOfCars()).isEqualTo(2);
  }

  void 자동차_추가_자동차_객체() {
    carRepository.addCar(new Car());
    carRepository.addCar(new Car(10));

    assertThat(carRepository.getNumberOfCars()).isEqualTo(2);
  }

  void 자동차_추가_자동차_개수() {
    carRepository.addCars(5);

    assertThat(carRepository.getNumberOfCars()).isEqualTo(5);
  }
}
