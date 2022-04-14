package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.domain.strategy.NumberCompareMoveStrategy.CAN_MOVE_NUMBER;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategy.FixedNumberGenerator;
import racing.domain.strategy.NumberCompareMoveStrategy;

class CarsTest {

  @ParameterizedTest
  @DisplayName("앞으로 1회 시도했을 때 이동 거리 확인")
  @ValueSource(ints = {1, 5, 9, 10})
  void oneMoveTest(int carCount) {
    //given
    Cars cars = new Cars(carCount,
        new NumberCompareMoveStrategy(new FixedNumberGenerator(CAN_MOVE_NUMBER + 1)));

    //when
    cars.attempt();

    //then
    assertThat(cars.getDistances()).hasSize(carCount).containsOnly(1);
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 시도했을 때 이동 거리 확인")
  @CsvSource(value = {"1|1|1", "2|2|2", "20|20|20", "25|25|25", "100|100|100"}, delimiter = '|')
  void nMoveTest(int carCount, int attempt, int expected) {
    //given
    Cars cars = new Cars(carCount,
        new NumberCompareMoveStrategy(new FixedNumberGenerator(CAN_MOVE_NUMBER + 1)));

    //when
    for (int i = 0; i < attempt; i++) {
      cars.attempt();
    }

    //then
    assertThat(cars.getDistances()).hasSize(carCount).containsOnly(attempt);
  }
}