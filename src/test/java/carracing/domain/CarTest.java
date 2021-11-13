package carracing.domain;

import carracing.domain.entity.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

  private Car car;

  @BeforeEach
  void init() {
    car = new Car();
  }

  @ParameterizedTest
  @ValueSource(ints = {1})
  @DisplayName("car 생성시 현재단계가 기본으로 1로 생성되어 출력되어야 한다.")
  void constructWithExceptionTest(int input) {
    assertThat(car.getNowStep()).isEqualTo(input);
  }

  @ParameterizedTest
  @CsvSource(value = {"1:1", "4:1", "15:2", "20:2"}, delimiter = ':')
  void moveTest(int number, int result) {
    car.move(isMoved(number));
    assertThat(car.getNowStep()).isEqualTo(result);
  }

  BooleanSupplier isMoved(int number) {
    return () -> number > 10;
  }

}