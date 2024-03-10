package racingcar.step4.service;

import racingcar.step4.domain.dto.ParticipantResultDto;
import racingcar.step4.domain.dto.RoundResultDto;
import racingcar.step4.domain.move.MoveStrategy;
import racingcar.step4.service.dto.RacingResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    private final RoundService roundService;
    private final int roundCount;

    public RacingService(MoveStrategy moveStrategy, int roundCount, List<String> names) {
        this.roundService = new RoundService(names, moveStrategy);
        this.roundCount = roundCount;
    }

    public RacingResultDto startRacingContest() {
        List<RoundResultDto> roundResults = new ArrayList<>();

        for (int i = 0; i < roundCount; i++) {
            roundResults.add(roundService.startRound());
        }

        return new RacingResultDto(getRacingWinners(roundResults), roundResults);
    }

    private List<String> getRacingWinners(List<RoundResultDto> roundResults) {
        if (isRoundResultNullOrEmpty(roundResults)) {
            return new ArrayList<>();
        }

        RoundResultDto finalRound = getFinalRound(roundResults);
        int winnerLocation = getWinnerLocation(finalRound);

        return getWinners(finalRound, winnerLocation);
    }

    private static boolean isRoundResultNullOrEmpty(List<RoundResultDto> roundResults) {
        return roundResults == null || roundResults.isEmpty();
    }

    private static RoundResultDto getFinalRound(List<RoundResultDto> roundResults) {
        return roundResults.get(roundResults.size() - 1);
    }

    private static Integer getWinnerLocation(RoundResultDto finalRound) {
        return finalRound.getParticipantResults() .stream()
                .map(ParticipantResultDto::getLocation)
                .max(Integer::compareTo)
                .get();
    }

    private static List<String> getWinners(RoundResultDto finalRound, int winnerLocation) {
        return finalRound.getParticipantResults().stream()
                .filter(x -> x.getLocation() == winnerLocation)
                .map(ParticipantResultDto::getName)
                .collect(Collectors.toList());
    }
}
