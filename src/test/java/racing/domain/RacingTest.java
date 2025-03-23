package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Racing;

class RacingTest {

  @Test
  void 자동차_객체_생성() {
    String[] carNames = {"pobi", "crong", "honux"};
    assertThat(new Racing(carNames).getCars().size()).isEqualTo(3);

  }

  @Test
  void 제일_높은_position_가진_자동차_구하기() {
    Car pobi = new Car("pobi", 3);
    Car jason = new Car("jason", 1);
    Car brown = new Car("brown", 2);

    List<Car> cars = List.of(pobi, jason, brown);

    Racing racing = new Racing(cars);

    List<String> winners = racing.findWinners();

    assertThat(winners).containsExactlyInAnyOrder("pobi");
  }

}