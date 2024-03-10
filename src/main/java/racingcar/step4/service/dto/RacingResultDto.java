package racingcar.step4.service.dto;

import racingcar.step4.domain.dto.RoundResultDto;

import java.util.List;

public class RacingResultDto {

    List<String> winners;
    List<RoundResultDto> roundResults;

    public RacingResultDto(List<String> winners, List<RoundResultDto> roundResults) {
        this.winners = winners;
        this.roundResults = roundResults;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<RoundResultDto> getRoundResults() {
        return roundResults;
    }
}
