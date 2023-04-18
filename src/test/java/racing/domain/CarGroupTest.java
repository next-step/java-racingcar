package racing.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarGroupTest {

  private CarGroup carGroup = new CarGroup("pobi,crong,honux");
  private MoveStrategy alwaysMoveStrategy = () -> true;

  @Test
  void 자동차_그룹이_모두_움직이는_경우() {
    carGroup.moveCars(alwaysMoveStrategy);
    List<Car> cars = carGroup.getCars();

    assertThat(cars).hasSize(3);
    assertThat(cars.get(0).position()).isEqualTo(1);
    assertThat(cars.get(1).position()).isEqualTo(1);
    assertThat(cars.get(2).position()).isEqualTo(1);
  }

  @Test
  void 자동차그룹에서_자동차들_가져오기() {
    List<Car> cars = carGroup.getCars();

    assertThat(cars).hasSize(3);
    assertThat(cars.get(0).name()).isEqualTo("pobi");
    assertThat(cars.get(1).name()).isEqualTo("crong");
    assertThat(cars.get(2).name()).isEqualTo("honux");
  }

  @Test
  void 자동차그룹에서_승리자_찾기() {
    carGroup.moveCars(alwaysMoveStrategy);
    String[] winners = carGroup.findWinners();

    assertThat(winners).hasSize(3);
    assertThat(winners[0]).isEqualTo("pobi");
    assertThat(winners[1]).isEqualTo("crong");
    assertThat(winners[2]).isEqualTo("honux");
  }
}