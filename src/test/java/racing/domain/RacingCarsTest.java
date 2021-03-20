package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static base.BaseMethodSource.RANDOM_NUMBER_BELOW_10;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차 일급 컬렉션 래퍼 객체 생성")
  void create(int totalPlayer) {
    // given

    // when
    RacingCars cars = RacingCars.create(totalPlayer);

    // then
    assertThat(cars.getRacingCars())
            .hasSize(totalPlayer);
  }

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차 일급 컬렉션 래퍼 객체 복사")
  void copyFrom(int totalPlayer) {
    // given
    RacingCars newCars = RacingCars.create(totalPlayer);

    // when
    RacingCars copiedCars = RacingCars.copyFrom(newCars);

    // then
    assertThat(copiedCars.hashCode())
            .isNotEqualTo(newCars.hashCode());
  }

  @ParameterizedTest
  @MethodSource(RANDOM_NUMBER_BELOW_10)
  @DisplayName("자동차 경주 테스트")
  void race(int totalPlayer) {
    // given
    RacingCars cars = RacingCars.create(totalPlayer);

    // when
    cars.race(() -> true);

    // then
    final int movePosition = 1;
    cars.getRacingCars()
            .forEach(car -> assertThat(car.position())
                                .isEqualTo(movePosition));
  }

  @Test
  @DisplayName("불변 자동차 리스트 테스트")
  void unmodifiableList() {
    // given
    List<RacingCar> paramCarsList = new ArrayList<>();
    paramCarsList.add(RacingCar.create("gmoon1"));
    paramCarsList.add(RacingCar.create("gmoon2"));
    RacingCars racingCars = RacingCars.create(paramCarsList);

    // when
    List<RacingCar> result = racingCars.getRacingCars();

    // then
    assertAll(() -> assertThatThrownBy(() -> result.add(RacingCar.create(0))).isInstanceOf(UnsupportedOperationException.class)
            , () -> assertThat(System.identityHashCode(result)).isNotEqualTo(System.identityHashCode(paramCarsList))
            , () -> assertThat(result).containsAll(paramCarsList)
    );

  }
}