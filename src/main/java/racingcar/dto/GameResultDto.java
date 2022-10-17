package racingcar.dto;

import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class GameResultDto {
    public final List<RoundResultDto> roundResultDtos = new ArrayList<>();

    public final List<String> winnerNames = new ArrayList<>();

    public void recordRoundResults(Cars cars) {
        roundResultDtos.add(new RoundResultDto(cars));
    }

    public void recordWinnerNames(List<String> winnerNames) {
        this.winnerNames.addAll(winnerNames);
    }
}
