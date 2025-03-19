package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingWinnerDeterminerTest {
  @Test
  @DisplayName("현재 가장 멀리 있는 자동차를 반환한다. (우승자 1명)")
  void getWinner() {
    //given
    List<Car> cars = new ArrayList<>();
    cars.add(new Car("pobi"));
    cars.add(new Car("crong"));
    cars.add(new Car("honux"));
    cars.get(1).move();

    //when
    List<String> winners = RacingWinnerDeterminer.getWinner(new Cars(cars));

    //then
    assertThat(winners).containsExactly("crong");
  }

  @Test
  @DisplayName("현재 가장 멀리 있는 자동차들을 반환한다. (우승자 3명)")
  void getWinners() {
    //given
    List<Car> cars = new ArrayList<>();
    cars.add(new Car("pobi"));
    cars.add(new Car("crong"));
    cars.add(new Car("honux"));
    cars.get(0).move();
    cars.get(1).move();
    cars.get(2).move();

    //when
    List<String> winners = RacingWinnerDeterminer.getWinner(new Cars(cars));

    //then
    assertThat(winners).containsExactlyInAnyOrder("pobi", "crong", "honux");
  }

}
