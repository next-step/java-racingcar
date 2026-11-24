package racingcar.domain;

import java.util.List;

public record RoundResult(List<CarResult> carResults) {
    public RoundResult {
        carResults = List.copyOf(carResults);
    }

    public List<CarName> getWinners() {
        int maxPosition = carResults.stream()
                .mapToInt(CarResult::position)
                .max()
                .orElseThrow();
        return carResults.stream()
                .filter(result -> result.position() == maxPosition)
                .map(CarResult::name)
                .toList();
    }
}
