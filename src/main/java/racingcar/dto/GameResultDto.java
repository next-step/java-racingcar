package racingcar.dto;

import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class GameResultDto {
    private final List<RoundResultDto> roundResultDtos = new ArrayList<>();

    public void recordResults(Cars cars) {
        roundResultDtos.add(new RoundResultDto(cars));
    }

    public List<RoundResultDto> getRoundResults() {
        return roundResultDtos;
    }
}
