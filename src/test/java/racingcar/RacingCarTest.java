package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.NormalMoveStrategy;


import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
  @Test
  @DisplayName("0~9사이 정수랜덤생성기")
  public void checkRandomNumber_ReturnPositiveNumberUnderNine() {
    RandomNumber randomNumber = new RandomNumber();
    int result = randomNumber.calculateRandomNumber();

    assertThat(result)
        .isGreaterThanOrEqualTo(0)
        .isLessThanOrEqualTo(9);
  }

  @Test
  @DisplayName("CarInterface 상속으로 RacingCar 객체 생성 후 position = 0인지 확인")
  public void createRacingCar_ReturnPositionValueZero() {
    RacingCar racingCar = new RacingCar();
    int result = racingCar.position();

    assertThat(result).isEqualTo(0);
  }

  @Test
  @DisplayName("전략패턴을 통한 RacingCar move 실행후 position = 1인지 확인")
  public void moveRacingCar_ReturnPositionValueOne() {
    RacingCar racingCar = new RacingCar();
    MoveStrategy normalMoveStrategy = new NormalMoveStrategy();

    racingCar.tryToMove(normalMoveStrategy);

    int result = racingCar.position();

    assertThat(result).isEqualTo(1);
  }

  @Test
  @DisplayName("자동차 객체 여러개 생성 되는지 확인")
  public void checkRacingCarsObject() {
    RacingCars racingCars = new RacingCars(5);

    assertThat(racingCars.statusOfRacingCars()).hasSize(5);
  }

  @Test
  @DisplayName("5대 자동차, 4번 움직임 시도(postion max값 == 4)인 racing 확인")
  public void checkRacingClass() {
    Racing racing = new Racing(new RacingCars(5));
    MoveStrategy normalMoveStrategy = new NormalMoveStrategy();
    int numberOfTrials = 4;

    while (numberOfTrials > 0) {
      racing.startRacingRound(normalMoveStrategy);
      numberOfTrials--;
    }

    assertThat(racing.statusOfRacing()).hasSize(5);
    assertThat(racing.statusOfRacing().get(0).position())
        .isLessThanOrEqualTo(4);

//        System.out.println("carNumber: " + resultRacing.getRacingCar(0).getNumber() + " position: " + resultRacing.getRacingCar(0).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(1).getNumber() + " position: " + resultRacing.getRacingCar(1).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(2).getNumber() + " position: " + resultRacing.getRacingCar(2).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(3).getNumber() + " position: " + resultRacing.getRacingCar(3).getPosition());
//        System.out.println("carNumber: " + resultRacing.getRacingCar(4).getNumber() + " position: " + resultRacing.getRacingCar(4).getPosition());
  }

}
