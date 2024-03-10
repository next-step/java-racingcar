package racingcar.step4.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.domain.move.IncrementMoveStrategy;
import racingcar.step4.service.dto.RacingResultDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {

    private final List<String> names = Arrays.asList("Luffy", "Naruto", "Ichigo");
    private final int roundCount = 3;

    @DisplayName("주어진 라운드만큼 경기를 수행하고, 각 참가자들은 이동한다.")
    @Test
    void startContestWithRoundCount() {
        // given
        RacingService racingService = new RacingService(
                new IncrementMoveStrategy(),
                roundCount,
                names
        );

        // when
        List<Integer> finalRoundParticipantsLocation = getFinalRoundParticipantsLocation(racingService);

        // then
        assertThat(finalRoundParticipantsLocation)
                .isEqualTo(new ArrayList<>(List.of(roundCount, roundCount, roundCount)));
    }

    @DisplayName("우승자를 구한다.")
    @Test
    void getWinnersOfRacing() {
        // given
        RacingService racingService = new RacingService(
                new IncrementMoveStrategy(),
                roundCount,
                names
        );

        // when
        RacingResultDto result = racingService.startRacingContest();
        List<String> winners = result.getWinners();

        // then
        assertThat(winners).isEqualTo(names);
    }

    private static List<Integer> getFinalRoundParticipantsLocation(RacingService racingService) {
        RacingResultDto result = racingService.startRacingContest();
        List<RoundResultDto> roundResults = result.getRoundResults();
        int finalRoundIndex = roundResults.size() - 1;

        RoundResultDto finalRound = roundResults.get(finalRoundIndex);
        return finalRound.getParticipantResults().stream()
                .map(ParticipantResultDto::getLocation)
                .collect(Collectors.toList());
    }
}