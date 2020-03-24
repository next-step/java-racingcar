package racingcar.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static racingcar.domain.RacingGameConstant.DELIMITER_COMMA;

public class RacingGameResultsDto {
    private final List<String> winners;
    private final Map<Integer, Cars> racingGameResults;

    public RacingGameResultsDto(List<String> winners, Map<Integer, Cars> racingGameResults) {
        this.winners = winners;
        this.racingGameResults = racingGameResults;
    }

    public Map<Integer, Cars> get() {
        return racingGameResults;
    }

    public String getWinners() {
        return winners.stream()
                .collect(Collectors.joining(DELIMITER_COMMA));
    }
}
