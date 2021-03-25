package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racing.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static base.BaseMethodSource.CARS_CREATE_ARGUMENTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingCarsTest {

  @ParameterizedTest
  @MethodSource(CARS_CREATE_ARGUMENTS)
  @DisplayName("자동차 일급 컬렉션 래퍼 객체 생성")
  void create(String names, int totalPlayer) {
    // given
    List<RacingCar> list = getRacingCarList(names);

    // when
    RacingCars cars = RacingCars.create(list);

    // then
    assertThat(cars.getRacingCars())
            .hasSize(totalPlayer);
  }

  @ParameterizedTest
  @MethodSource(CARS_CREATE_ARGUMENTS)
  @DisplayName("자동차 일급 컬렉션 래퍼 객체 복사")
  void copyFrom(String names) {
    // given
    RacingCars newCars = RacingCars.create(getRacingCarList(names));

    // when
    RacingCars copiedCars = RacingCars.copyFrom(newCars);

    // then
    assertThat(copiedCars.hashCode())
            .isNotEqualTo(newCars.hashCode());
  }

  @ParameterizedTest
  @MethodSource(CARS_CREATE_ARGUMENTS)
  @DisplayName("자동차 경주 테스트")
  void race(String names) {
    // given
    RacingCars newCars = RacingCars.create(getRacingCarList(names));

    // when
    newCars.race(() -> true);

    // then
    newCars.getRacingCars()
            .forEach(car -> assertThat(car.position())
                                .isEqualTo(Position.create(1)));
  }

  @Test
  @DisplayName("불변 자동차 리스트 테스트")
  void unmodifiableList() {
    // given
    List<RacingCar> paramCarsList = Arrays.asList(
              RacingCar.create("gmoon")
            , RacingCar.create("toby"));
    RacingCars racingCars = RacingCars.create(paramCarsList);

    // when
    List<RacingCar> result = racingCars.getRacingCars();

    // then
    assertAll(() -> assertThatThrownBy(() -> result.add(RacingCar.create("new"))).isInstanceOf(UnsupportedOperationException.class)
            , () -> assertThat(System.identityHashCode(result)).isNotEqualTo(System.identityHashCode(paramCarsList))
            , () -> assertThat(result).containsAll(paramCarsList)
    );
  }

  private List<RacingCar> getRacingCarList(String names) {
    return StringUtils.toList(names).stream()
            .map(RacingCar::create)
            .collect(Collectors.toList());
  }

}