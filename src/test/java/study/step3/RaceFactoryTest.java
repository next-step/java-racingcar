package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.step3.domain.Race;
import study.step3.factory.CarFactory;
import study.step3.factory.RaceFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceFactoryTest {

  @DisplayName("자동차 댓수 만큼 자동차를 생성하여 주입받은 race를 만든다.")
  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  public void create_race_numberOfCars(int input) {
    Race race = RaceFactory.createRace(input);

    assertThat(race.getCarList().size()).isEqualTo(input);
  }
}
