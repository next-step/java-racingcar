package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundResults {
    private final List<RoundResult> roundResults = new ArrayList<>();

    public void recordResults(List<CarResultDto> currentCars) {
        roundResults.add(new RoundResult(currentCars));
    }

    public List<List<CarResultDto>> getResults() {
        return roundResults.stream()
                .map(RoundResult::getResults)
                .collect(Collectors.toList());
    }
}
