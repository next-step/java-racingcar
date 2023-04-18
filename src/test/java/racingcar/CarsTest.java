package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.Cars;
import racingcar.application.RandomMoveStrategy;
import racingcar.dto.CarNames;

public class CarsTest {

  @Test
  @DisplayName("입력받은 숫자만큼 Car를 생성한다")
  void carsSizeTest() {
    // given
    final CarNames carNames = new CarNames("pobi,crong,honux");
    final int PROGRESS_NUMBER = 4;

    Cars cars = new Cars(() -> PROGRESS_NUMBER, carNames);

    // when & then
    assertThat(cars.locationValues()).hasSameSizeAs(carNames.carNames());
  }

  @Test
  @DisplayName("자동차 전진시 위치 값이 달라진다")
  void carsLocationValuesTest() {
    // given
    final CarNames carNames = new CarNames("pobi,crong,honux");
    final int PROGRESS_NUMBER = 4;

    Cars cars = new Cars(new RandomMoveStrategy(() -> PROGRESS_NUMBER), carNames);
    assertThat(cars.locationValues()).containsExactly(1, 1, 1);

    // when
    cars.go();

    // then
    assertThat(cars.locationValues()).containsExactly(2, 2, 2);
  }
}
