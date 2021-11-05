package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.dto.RoundReadyDTO;
import racingcar.service.dto.RoundResultDTO;
import racingcar.service.strategy.RandomRoundRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RacingCarServiceTest {
    private static final RoundReadyDTO readyDTO = RoundReadyDTO.of(new RandomRoundRule(),
                                                                   Arrays.asList("pobi", "crong", "honux"),
                                                                   5);

    private RacingCarService racingCarService;

    @BeforeEach
    void setup() {
        racingCarService = RacingCarService.ready(readyDTO);
    }

    @Test
    @DisplayName("정상적으로 record 정보를 가지고 오는지 확인")
    void getCars() {
        RoundResultDTO roundResultDTO = racingCarService.startRound();
        assertNotNull(roundResultDTO);
        assertThat(roundResultDTO.getRecords().size()).isEqualTo(readyDTO.getTotalRoundCount());
    }
}
