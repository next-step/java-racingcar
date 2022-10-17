package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.SameNumberGenerateStrategy;
import racingcar.strategy.NumberGenerateStrategy;

class RacingTest {

    @Test
    @DisplayName("race 메소드는 파라미터로 들어온 횟수만큼 경주를 진행한다.")
    void race_result() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Racing racing = new Racing(carNames);
        racing.race(5);

        assertThat(racing.getResult()).hasSize(5);
    }

    @Test
    @DisplayName("winners 메소드는 경주 우승자 리스트를 반환한다.")
    void return_winners() {
        List<String> carNames = List.of("jordy", "penda", "kero");
        Racing racing = new Racing(carNames, new SameNumberGenerateStrategy());
        racing.race(5);

        assertThat(racing.winners()).hasSize(3);
    }
}