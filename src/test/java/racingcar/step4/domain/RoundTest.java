package racingcar.step4.domain;

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

class RoundTest {

    @DisplayName("move를 통해 모든 참가자들에게 이동명령을 내린다.")
    @Test
    void orderToMoveWithMove() {
        // given
        List<String> names = Arrays.asList("Luffy", "Narut", "Ichig");
        Round round = new Round(new IncrementMoveStrategy(), new Names(names));

        // when
        round.move();
        RoundResultDto result = round.move();

        // then
        assertThat(result.getParticipantResults().stream()
                .map(ParticipantResultDto::getCurrentLocation).collect(Collectors.toList())
        ).isEqualTo(new ArrayList<>(List.of(2, 2, 2)));
    }
}