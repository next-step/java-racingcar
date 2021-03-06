package racing.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

  private RacingGame racingGame;


  List<RacingCar> init() {
    racingGame = new RacingGame();
    return racingGame.setUp(3);
  }

  @DisplayName("레이싱 게임 초기화 테스트")
  @Test
  void setUp() {
    List<RacingCar> racingCar = init();

    //then
    assertEquals(3, racingCar.size());
  }

  @DisplayName("랜덤값이 자동차 갯수 만큼 생성되는지 테스트")
  @Test
  void createRandomValue() {
    //given
    List<RacingCar> racingCar = init();

    //when
    List<Integer> randomValue = racingGame.createRandomValue();

    //then
    assertEquals(3, randomValue.size());
  }


  @DisplayName("이동거리가 4이상일때 자동차 이동 테스트")
  @Test
  void move() {
    //given
    List<RacingCar> racingCar = init();
    List<Integer> randomValue = createMoveValue(5, 7, 8);

    //when
    racingGame.moveAndStop(randomValue);

    //then
    assertEquals(5, racingCar.get(0).getPosition());
    assertEquals(7, racingCar.get(1).getPosition());
    assertEquals(8, racingCar.get(2).getPosition());
  }

  @DisplayName("이동거리가 4미만일때 자동차 정지 테스트")
  @Test
  void stop() {
    //given
    List<RacingCar> racingCar = init();
    List<Integer> randomValue = createMoveValue(2, 3, 1);

    //when
    racingGame.moveAndStop(randomValue);

    //then
    assertEquals(0, racingCar.get(0).getPosition());
    assertEquals(0, racingCar.get(1).getPosition());
    assertEquals(0, racingCar.get(2).getPosition());
  }


  private List<Integer> createMoveValue(int firstCarMovePosition, int secondCarMovePosition,
      int thirdCarMovePosition) {
    List<Integer> randomValue = new ArrayList<>();
    randomValue.add(firstCarMovePosition);
    randomValue.add(secondCarMovePosition);
    randomValue.add(thirdCarMovePosition);
    return randomValue;
  }


}