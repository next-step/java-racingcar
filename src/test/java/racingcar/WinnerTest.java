package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarName;
import racingcar.domain.Winner;

class WinnerTest {

  @Test
  @DisplayName("Winner가 정상적으로 생성된다.")
  void createWinner() {
    // given
    // when
    CarName[] names = {new CarName("a"), new CarName("b")};
    Winner winner = Winner.of(Lists.list(names));

    // then
    assertAll(
        () -> assertThat(winner.getWinners()).contains(names),
        () -> assertThat(winner.winnerListString()).isEqualTo(Arrays.stream(names)
            .map(CarName::getName)
            .collect(Collectors.joining(Winner.DELIMITER)))
    );
  }
}
