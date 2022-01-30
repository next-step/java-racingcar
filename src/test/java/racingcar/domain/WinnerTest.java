package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;
import racingcar.service.RacingService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnerTest {
    RacingService racingService;

    @BeforeEach
    void setUp() {
        List<String> carNames = new ArrayList<>(Arrays.asList("c", "java", "jpa"));
        racingService = RacingService.from(Cars.of(carNames, new FixedForwardStrategy(true)));
    }

    @Test
    void winnerTest() {
        racingService.drive();
        assertThat(racingService.judgeWinners()).containsExactly("c", "java", "jpa");
    }

    @Test
    void noWinnerTest() {
        assertThat(racingService.judgeWinners().size()).isEqualTo(0);
    }

}
