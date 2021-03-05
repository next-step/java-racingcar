package racing.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

  @DisplayName("자동차 이동 테스트")
  @Test
  void moveTest() {
    //given
    RacingCar car = new RacingCar(0);
    int moveCount = 5;

    //when
    car.move(moveCount);

    //then
    assertEquals(5, car.getPosition());
  }

}