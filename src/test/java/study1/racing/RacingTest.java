package study1.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {
  @Test
  @DisplayName("racing 개발용 테스트")
  void racingTest() {
    Race race = new Race(5, 3);
    race.run();
  }
}
