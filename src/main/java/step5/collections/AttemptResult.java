package step5.collections;

import step5.dto.CarWentResult;

import java.util.*;
import java.util.stream.Collectors;

import static step5.constants.MessageConstant.NOT_FOUND_FIRST;

public class AttemptResult {

    private static final int FIRST_INDEX = 0;

    private List<CarWentResult> carWentResults;

    public AttemptResult(List<CarWentResult> carWentResults) {
        this.carWentResults = carWentResults;
    }

    public String getWinnersNames() {
        List<CarWentResult> originResult = this.carWentResults;
        if(originResult.size() == 0) {
            throw new IllegalStateException(NOT_FOUND_FIRST);
        }
        List<CarWentResult> sorted = sortByDistanceDesc(originResult);
        return collectWinnersNames(sorted);
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

    private List<CarWentResult> sortByDistanceDesc(List<CarWentResult> carWentResults) {
        return carWentResults.stream()
                .sorted(Comparator.comparingInt(CarWentResult::getDistance).reversed())
                .collect(Collectors.toList());
    }

    private String collectWinnersNames(List<CarWentResult> sorted) {
        int firstDistance = sorted.get(FIRST_INDEX).getDistance();
        return sorted.stream()
                .filter(carWentResult -> carWentResult.getDistance() == firstDistance)
                .map(carWentResult -> carWentResult.getCarName())
                .collect(Collectors.joining(","));
    }
}
