package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
import study.step3.domain.Race;
import study.step3.factory.CarFactory;
import study.step3.factory.RaceFactory;

public class RaceTest {

  @DisplayName("경기 한번 당 모든 자동차들은 랜덤하게 1칸 전진하거나 전진하지 않는다.")
  @Test
  public void play_forwardOrStop_carList() {
    Race race = RaceFactory.createRace(5);

    race.play();

    for (Car car : race.getCarList()) {
      assertThat(car.getDistance()).isLessThanOrEqualTo(1);
    }
  }
}
