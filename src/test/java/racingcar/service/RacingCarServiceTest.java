package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.dto.RoundReady;
import racingcar.service.dto.RoundResult;
import racingcar.service.strategy.RandomRoundRule;
import racingcar.value.Round;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RacingCarServiceTest {
    private static final RoundReady roundReady = RoundReady.of(new RandomRoundRule(),
                                                               Arrays.asList("pobi", "crong", "honux"),
                                                               Round.from(5));

    private RacingCarService racingCarService;

    @BeforeEach
    void setup() {
        racingCarService = RacingCarService.ready(roundReady);
    }

    @Test
    @DisplayName("정상적으로 record 정보를 가지고 오는지 확인")
    void getCars() {
        RoundResult roundResult = racingCarService.startRound();
        assertNotNull(roundResult);
        assertThat(roundResult.getRecords().size()).isEqualTo(roundReady.getFinalRound().getRound());
    }
}
