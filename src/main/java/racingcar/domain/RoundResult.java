package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.List;

public class RoundResult {
    private final List<CarResultDto> results;

    public RoundResult(List<CarResultDto> results) {
        this.results = results;
    }

    public List<CarResultDto> getResults() {
        return results;
    }
}
