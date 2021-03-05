package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GarageTest {

  @ParameterizedTest
  @DisplayName("Garage는 자동차를 입력받은 만큼 관리할 수 있다.")
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void garageContainsCars(int size) {
    // given
    Garage garage = new Garage();

    // when
    garage.initializeCars(size);

    // then
    assertThat(garage.getCarCount()).isEqualTo(size);
  }
}
