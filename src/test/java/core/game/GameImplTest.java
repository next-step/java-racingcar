package core.game;

import static org.assertj.core.api.Assertions.assertThat;

import core.car.Car;
import core.car.CarImpl;
import core.car.CarInterface;
import core.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameImplTest {

  Util util = new Util();
  CarInterface carImpl = new CarImpl(util);
  GameImpl gameImpl = new GameImpl(util, carImpl);

  @Test
  @DisplayName("게임 생성 성공")
  void createGame() {
    // given
    Car car1 = new Car("pobi", 0);
    Car car2 = new Car("woni", 0);
    Car car3 = new Car("jun", 0);
    List<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
    Game expectResult = new Game(cars);
    // when
    Game result = gameImpl.createGame(cars);
    // then
    assertThat(result).isEqualToComparingFieldByField(expectResult);
  }
}