package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
import study.step3.domain.Race;
import study.step3.factory.RaceFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceFactoryTest {

  @DisplayName("이름배열 순서에 맞게 이름을 갖는 자동차를 생성하여 주입받은 race를 만든다.")
  @Test
  public void create_race_nameOfCars() {
    String[] names = new String[]{"a","b","c"};

    Race race = RaceFactory.createRace(names);

    List<Car> cars = race.getCars();
    assertThat(cars.size()).isEqualTo(names.length);
    for (int i = 0; i < names.length; i++) {
      assertThat(cars.get(i).getName()).isEqualTo(names[i]);
    }
  }
}
