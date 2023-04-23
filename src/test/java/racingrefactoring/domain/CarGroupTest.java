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
    Car car1 = new Car("car1", 3);
    Car car2 = new Car("car2", 1);
    Car car3 = new Car("car3", 2);

    CarGroup carGroup = new CarGroup(car1, car2, car3);

    assertThat(carGroup.findWinners()).isEqualTo(new Winners(car1));
  }
}