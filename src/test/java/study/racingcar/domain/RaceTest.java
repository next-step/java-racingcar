package study.racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.factory.RaceFactory;

public class RaceTest {

  @DisplayName("경기 한번 당 모든 자동차들은 랜덤하게 1칸 전진하거나 전진하지 않는다.")
  @Test
  public void play_forwardOrStop_cars() {
    String[] names = new String[]{"a", "b", "c"};
    Race race = RaceFactory.createRace(names);

    race.play();

    for (Car car : race.getCars()) {
      assertThat(car.getDistance()).isLessThanOrEqualTo(1);
    }
  }

  @DisplayName("우승한 자동차들의 이름을 반환한다.")
  @Test
  public void getWinners_Names_cars() {
    Race race = RaceFactory.createRace(new String[]{"1", "2", "3", "4", "5"});
    race.play();
    List<String> winnerNames = getWinnerNames(race);

    if (!winnerNames.isEmpty()) {
      assertThat(race.getWinners()).containsExactlyElementsOf(winnerNames);
    }
  }

  private List<String> getWinnerNames(Race race) {
    List<String> winnerNames = new ArrayList<>();
    for (Car car : race.getCars()) {
      if (car.getDistance() > 0) {
        winnerNames.add(car.getName());
      }
    }
    return winnerNames;
  }
}
