package racingcar.domain;

import racingcar.dto.CarResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RoundResults {
    private final List<RoundResult> roundResults = new ArrayList<>();

    public void recordResults(Cars cars) {
        roundResults.add(new RoundResult(cars));
    }

    public List<List<CarResultDto>> getResults() {
        return roundResults.stream()
                .map(RoundResult::getResults)
                .collect(Collectors.toList());
    }
}
