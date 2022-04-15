package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategy.MustMoveStrategy;
import racing.domain.strategy.NameLengthValidationStrategy;

class NamedCarsTest {

  @ParameterizedTest
  @DisplayName("앞으로 1회 시도했을 때 이동 거리와 자동차 이름 확인")
  @ValueSource(strings = {"test1,test2,test3", "A,B,C,D", "car1,car2,car3", "자동차1,자동차2,자동차3"})
  void oneMoveTest(String carNameInput) {
    //given
    NamedCars namedCars = NamedCars.newInstance(carNameInput, new NameLengthValidationStrategy(),
        new MustMoveStrategy());

    //when
    namedCars.attempt();

    //then
    assertThat(namedCars.getDistances()).hasSize(
        carNameInput.split(NamedCars.CAR_NAME_DELIMITER).length).containsOnly(1);
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 시도했을 때 이동 거리와 자동차 이름 확인")
  @CsvSource(value = {"test1,test2,test3|1|1", "A,B,C,D|2|2", "car1,car2,car3|20|20",
      "자동차1,자동차2,자동차3|25|25"}, delimiter = '|')
  void nMoveTest(String carNameInput, int attempt, int expected) {
    //given
    NamedCars namedCars = NamedCars.newInstance(carNameInput, new NameLengthValidationStrategy(),
        new MustMoveStrategy());

    //when
    for (int i = 0; i < attempt; i++) {
      namedCars.attempt();
    }

    //then
    assertThat(namedCars.getDistances()).hasSize(
        carNameInput.split(NamedCars.CAR_NAME_DELIMITER).length).containsOnly(attempt);
  }
}