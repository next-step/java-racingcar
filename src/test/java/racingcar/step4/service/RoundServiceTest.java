package racingcar.step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.domain.move.IncrementMoveStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RoundServiceTest {

    @DisplayName("한 라운드를 시작하면, 각 참가자들은 이동을 시도한다.")
    @Test
    void moveParticipantsWhenStartRound() {
        // given
        List<String> names = Arrays.asList("Luffy", "Narut", "Ichig");
        RoundService roundService = new RoundService(names, new IncrementMoveStrategy());

        // when
        roundService.startRound();
        RoundResultDto result = roundService.startRound();

        // then
        assertThat(result.getParticipantResults().stream()
                .map(ParticipantResultDto::getLocation).collect(Collectors.toList())
        ).isEqualTo(new ArrayList<>(List.of(2, 2, 2)));
    }
}