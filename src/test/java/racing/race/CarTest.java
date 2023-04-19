package racing.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.strategy.MoveNumberStrategy;
import racing.strategy.StopNumberStrategy;

class CarTest {

  Cars cars;

  @BeforeEach
  public void init() {
    cars = new Cars("pobi,crong,honux");
  }

  @Test
  void 자동차는멈출수있다() {
    StopNumberStrategy stopNumberStrategy = new StopNumberStrategy();
    cars.getGameCars().get(1).move(stopNumberStrategy);

    assertThat(cars.getGameCars().get(1).moveDistance()).isEqualTo(0);
  }

  @Test
  void 자동차는전진할수있다() {
    MoveNumberStrategy moveNumberStrategy = new MoveNumberStrategy();
    cars.getGameCars().get(1).move(moveNumberStrategy);

    assertThat(cars.getGameCars().get(1).moveDistance()).isEqualTo(1);
  }

}