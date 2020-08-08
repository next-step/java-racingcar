package step5.collections;

import step5.dto.CarWentResult;

import java.util.*;
import java.util.stream.Collectors;

import static step5.constants.MessageConstant.NOT_FOUND_FIRST;

public class AttemptResult {

    private final List<CarWentResult> carWentResults;

    public AttemptResult(List<CarWentResult> carWentResults) {
        this.carWentResults = carWentResults;
    }

    public String getWinnersNames() {
        int firstDistance = this.carWentResults
                                .stream()
                                .max(Comparator.comparing(CarWentResult::getDistance))
                                .map(CarWentResult::getDistance)
                                .orElseThrow(() -> new IllegalStateException(NOT_FOUND_FIRST));

        return this.carWentResults
                    .stream()
                    .filter(carWentResult -> carWentResult.getDistance() == firstDistance)
                    .map(CarWentResult::getCarName)
                    .collect(Collectors.joining(", "));
    }

    public List<CarWentResult> getCarWentResults() {
        return carWentResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttemptResult that = (AttemptResult) o;
        return carWentResults.equals(that.carWentResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carWentResults);
    }
}
