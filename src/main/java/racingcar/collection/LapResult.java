package racingcar.collection;


import racingcar.model.MoveResultDto;

import java.util.*;
import java.util.stream.Collectors;

public class LapResult {
    private final List<MoveResultDto> results = new ArrayList<>();

    public List<CarName> getCarNames() {
        return results.stream()
                .map(MoveResultDto::getCarName)
                .collect(Collectors.toList());
    }

    public void addResult(MoveResultDto result) {
        results.add(result);
    }

    public Integer getCarPositionResult(CarName carName) {
        return results.stream()
                .filter(result -> result.getCarName().equals(carName))
                .findFirst()
                .get().getPosition();
    }
}
