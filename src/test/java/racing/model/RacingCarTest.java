package racing.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

  private RacingCar racingCar;

  @BeforeEach
  void init() {
    racingCar = new RacingCar(0);

  }

  @DisplayName("자동차 이동 테스트")
  @Test
  void moveTest() {
    //given
    int moveCount = 5;

    //when
    racingCar.move(moveCount);

    //then
    assertEquals(5, racingCar.getPosition());
  }

  @DisplayName("자동차 이동거리가 4이상이면 전진하라는 신호를 보내는 메서드 테스트")
  @Test
  void isForward() {
    assertTrue(racingCar.isForward(5));
  }

  @DisplayName("자동차 이동거리가 4이상이면 전진하라는 신호를 보내는 메서드 테스트")
  @Test
  void isStop() {
    assertFalse(racingCar.isForward(0));
  }

}