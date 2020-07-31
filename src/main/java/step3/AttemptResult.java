package step3;

import java.util.Comparator;
import java.util.List;

public class AttemptResult {

    private List<CarWentResult> carWentResults;

    private static final String NOT_FOUND_FIRST = "경주 시도 결과가 없습니다.";

    public AttemptResult(List<CarWentResult> carWentResults) {
        this.carWentResults = carWentResults;
    }

    public Integer getFistCarNumber() {
        return this.carWentResults.stream()
                        .sorted(Comparator.comparingInt(CarWentResult::getDistance).reversed())
                        .findFirst()
                        .map(CarWentResult::getCarNumber)
                        .orElseThrow(()->new IllegalStateException(NOT_FOUND_FIRST));
    }


}
