package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategy.MustMoveStrategy;
import racing.domain.strategy.MustNotMoveStrategy;

class CarsTest {

  @ParameterizedTest
  @DisplayName("앞으로 1회 시도했을 때 이동 거리와 자동차 이름 확인")
  @ValueSource(strings = {"test1,test2,test3", "A,B,C,D", "car1,car2,car3", "자동차1,자동차2,자동차3"})
  void oneMoveTest(String carNameInput) {
    //given
    Cars cars = Cars.newInstance(carNameInput);
    List<Distance> distanceExpected = Arrays.asList(
        new Distance(1), new Distance(1), new Distance(1));

    //when
    cars.attempt(new MustMoveStrategy());

    //then
    assertAll(
        () -> assertThat(cars.matchDistances(distanceExpected)),
        () -> assertThat(cars.getNames()).containsExactlyElementsOf(
            Arrays.asList(carNameInput.split(Cars.CAR_NAME_DELIMITER)))
    );
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 시도했을 때 이동 거리와 자동차 이름 확인")
  @CsvSource(value = {"test1,test2,test3|1|1", "A,B,C,D|2|2", "car1,car2,car3|20|20",
      "자동차1,자동차2,자동차3|25|25"}, delimiter = '|')
  void nMoveTest(String carNameInput, int attempt, int expected) {
    //given
    MustMoveStrategy mustMoveStrategy = new MustMoveStrategy();
    Cars cars = Cars.newInstance(carNameInput);
    List<Distance> distanceExpected = new ArrayList<>();
    for (int i = 0; i < carNameInput.split(Cars.CAR_NAME_DELIMITER).length; i++) {
      distanceExpected.add(new Distance(expected));
    }

    //when
    for (int i = 0; i < attempt; i++) {
      cars.attempt(mustMoveStrategy);
    }

    //then
    assertAll(
        () -> assertThat(cars.matchDistances(distanceExpected)),
        () -> assertThat(cars.getNames()).containsExactlyElementsOf(
            Arrays.asList(carNameInput.split(Cars.CAR_NAME_DELIMITER)))
    );
  }

  @Test
  @DisplayName("자동차들 중 제일 멀리 이동한 자동차가 우승자로 선정되는지 확인")
  void winnerTest() {
    //given
    MustMoveStrategy mustMoveStrategy = new MustMoveStrategy();
    MustNotMoveStrategy mustNotMoveStrategy = new MustNotMoveStrategy();
    Cars winCars = Cars.newInstance("win1,win2");
    Cars loseCars = Cars.newInstance("lose1,lose2,lose3");
    Cars allCars = new Cars(
        Stream.concat(winCars.getValues().stream(), loseCars.getValues().stream())
            .collect(Collectors.toList()));

    int attempt = 100;
    for (int i = 0; i < attempt; i++) {
      winCars.attempt(mustMoveStrategy);
    }
    for (int i = 0; i < attempt; i++) {
      loseCars.attempt(mustNotMoveStrategy);
    }

    //when
    Cars winners = allCars.getWinners();

    //then
    assertThat(winCars.getValues()).containsExactlyElementsOf(winners.getValues());

  }
}