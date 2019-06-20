package racingcar;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.util.drivingStrategy.DrivingStrategy;
import racingcar.util.drivingStrategy.MockDrivingStrategy;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class RacingGameTest {

  private RacingGame racingGame;

  @BeforeEach
  void setUp() {
    DrivingStrategy drivingStrategy = MockDrivingStrategy.getInstance();
    String[] names = {"car1", "car2", "car3"};
    racingGame = new RacingGame(names, drivingStrategy);
  }

  @Test
  @DisplayName("race() 메소드 한번에 position이 1씩 증가")
  void race() {
    List<Car> racingCars = racingGame.race();
    assertThat(racingCars.get(0).getPosition()).isEqualTo(2);
    assertThat(racingCars.get(1).getPosition()).isEqualTo(2);
    assertThat(racingCars.get(2).getPosition()).isEqualTo(2);

    racingCars = racingGame.race();
    assertThat(racingCars.get(0).getPosition()).isEqualTo(3);
    assertThat(racingCars.get(1).getPosition()).isEqualTo(3);
    assertThat(racingCars.get(2).getPosition()).isEqualTo(3);

    racingCars = racingGame.race();
    assertThat(racingCars.get(0).getPosition()).isEqualTo(4);
    assertThat(racingCars.get(1).getPosition()).isEqualTo(4);
    assertThat(racingCars.get(2).getPosition()).isEqualTo(4);
  }

  @Test
  @DisplayName("우승자 이름을 String[] 으로 Return")
  void awards() {
    List<Car> racingCars = racingGame.race();
    assertThat(racingCars.get(0).getPosition()).isEqualTo(2);
    assertThat(racingCars.get(1).getPosition()).isEqualTo(2);
    assertThat(racingCars.get(2).getPosition()).isEqualTo(2);

    assertThat(racingGame.awards()).contains("car1", "car2", "car3");
  }
}
