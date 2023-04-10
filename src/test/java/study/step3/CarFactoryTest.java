package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarFactoryTest {

  @DisplayName("입력받은 자동차 댓수 만큼 자동차를 생성한다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  public void create_CarArr_num(int input) {
    Car[] cars = CarFactory.createCars(input);

    assertThat(cars.length).isEqualTo(input);
  }
}
