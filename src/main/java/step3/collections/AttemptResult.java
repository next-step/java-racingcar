package step3.collections;

import step3.dto.CarWentResult;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static step3.constants.MessageConstant.NOT_FOUND_FIRST;

public class AttemptResult {

    private List<CarWentResult> carWentResults;

    public AttemptResult(List<CarWentResult> carWentResults) {
        this.carWentResults = carWentResults;
    }

    public int getFirstCarNumber() {
        return this.carWentResults.stream()
                        .max(Comparator.comparingInt(CarWentResult::getDistance))
                        .map(CarWentResult::getCarNumber)
                        .orElseThrow(()->new IllegalStateException(NOT_FOUND_FIRST));
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
