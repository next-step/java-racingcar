package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.CarFactory;
import study.step3.domain.Cars;

public class CarFactoryTest {

  @DisplayName("자동차 대수를 입력한 수 만큼 자동차를 생산하는지 테스트")
  @Test
  void carFactory() {
    // given
    int carNumber = 3;

    // when
    Cars cars = CarFactory.makeCars(carNumber);

    // then
    assertThat(cars.getCars().size()).isEqualTo(carNumber);
  }

  @DisplayName("자동차 대수를 0으로 입력했을 때, 자동차 객체 생성에 실패하는지 테스트")
  @Test
  void carFactoryFail() {
    // given
    int carNumber = 0;

    // when
    Cars cars = CarFactory.makeCars(carNumber);

    // then
    assertThat(cars.getCars().size()).isEqualTo(carNumber);
  }

}
