package racing;

import static org.assertj.core.api.Assertions.assertThat;

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
    String[] carNames = {"pobi", "crong", "honux"};
    Racing racing = new Racing(carNames);
    List<Car> cars = racing.getCars();

    cars.get(0).driveOrStop(0);
    cars.get(1).driveOrStop(5);
    cars.get(2).driveOrStop(5);

    List<String> winners = racing.getMaxPosition();

    assertThat(winners).containsExactlyInAnyOrder("crong", "honux");
  }

}