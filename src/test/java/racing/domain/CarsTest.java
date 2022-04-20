package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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
    Cars carsExpected = Cars.newInstance(carNameInput, new Distance(1));

    //when
    cars.attempt(new MustMoveStrategy());

    //then
    assertThat(cars).isEqualTo(carsExpected);
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 시도했을 때 이동 거리와 자동차 이름 확인")
  @CsvSource(value = {"test1,test2,test3|1|1", "A,B,C,D|2|2", "car1,car2,car3|20|20",
      "자동차1,자동차2,자동차3|25|25"}, delimiter = '|')
  void nMoveTest(String carNameInput, int attempt, int expected) {
    //given
    MustMoveStrategy mustMoveStrategy = new MustMoveStrategy();
    Cars cars = Cars.newInstance(carNameInput);
    Cars carsExpected = Cars.newInstance(carNameInput, new Distance(expected));

    //when
    for (int i = 0; i < attempt; i++) {
      cars.attempt(mustMoveStrategy);
    }

    //then
    assertThat(cars).isEqualTo(carsExpected);
  }

  @Test
  @DisplayName("자동차들 중 제일 멀리 이동한 자동차가 우승자로 선정되는지 확인")
  void winnerTest() {
    //given
    MustMoveStrategy mustMoveStrategy = new MustMoveStrategy();
    MustNotMoveStrategy mustNotMoveStrategy = new MustNotMoveStrategy();
    List<Car> allCars = new ArrayList<>();
    allCars.add(new Car("win1", new Distance(100)));
    allCars.add(new Car("lose1", new Distance(1)));
    allCars.add(new Car("win2", new Distance(100)));
    allCars.add(new Car("lose2", new Distance(1)));
    allCars.add(new Car("lose3", new Distance(1)));
    Cars cars = new Cars(allCars);
    Cars winCars = Cars.newInstance("win1,win2", new Distance(100));

    //when
    Cars winners = cars.getWinners();

    //then
    assertThat(winners).isEqualTo(winCars);

  }
}