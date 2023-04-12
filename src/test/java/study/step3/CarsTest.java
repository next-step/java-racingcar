package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.domain.racingGame.Car;
import study.domain.racingGame.Cars;

public class CarsTest {

  Cars cars;

  @BeforeEach
  void setUp() {
    cars = new Cars();
  }

  @DisplayName("차량 추가 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1,1", "2,2", "3,3"})
  public void addCarsTest(int carCnt, int expected) {
    cars.addCars(carCnt);
    assertThat(cars.findTotalCarsCount()).isEqualTo(expected);
  }

  @DisplayName("차량 모두 움직이는 지 태스트")
  @Test
  public void moveAllCarsTest() {
    cars.addCars(5);
    cars.moveAll();
    for (Car car : cars) {
      assertThat(car.findTotalDistance()).isLessThanOrEqualTo(1);
    }
  }
}
