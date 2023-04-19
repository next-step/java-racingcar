package racingrefactoring.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarGroupTest {

  @Test
  void 자동차_모두_움직이는_경우() {
    CarGroup carGroup = new CarGroup("car1,car2,car3");
    carGroup.moveCars(() -> true);

    for(Car car : carGroup.getCars()) {
      assertThat(car.getPosition()).isEqualTo(1);
    }
  }

  @Test
  void 자동차_경주_승리자를_찾는_경우() {
    CarGroup carGroup = new CarGroup("car1,car2,car3");
    carGroup.moveCars(() -> true);
    carGroup.moveCars(() -> true);
    carGroup.moveCars(() -> true);

    assertThat(carGroup.findWinners()).containsExactly("car1", "car2", "car3");
  }
}