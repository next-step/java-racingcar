import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

  private RacingCars racingCars;
  private String[] playerNames = {"a", "bb", "ccccc"};

  @BeforeEach
  void setUp() {
    MoveStrategy alwaysMoveStrategy = () -> true;
    this.racingCars = new RacingCars(playerNames);
    this.racingCars.moveEachCars(alwaysMoveStrategy);
  }

  @Test
  @DisplayName("RacingCars 승자결정 로직을 검증하기 위한 테스트")
  void setWinnerNames() {
    // when
    List<RacingCar> cars = racingCars.findWinners();
    List<String> winnerNames = cars.stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());

    // then
    boolean containsAll = winnerNames.containsAll(Arrays.asList(this.playerNames));
    assertThat(containsAll).isTrue();
  }

}
