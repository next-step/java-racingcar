package study1.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
  @Test
  @DisplayName("racing 개발용 테스트")
  void racingTest() {
    Race race = new Race(5, 4);
    race.run();
    // Car car = new Car();
    // car.move();
    // car.move();
    // car.move();
    // car.move();
    // car.move();
  }
}
