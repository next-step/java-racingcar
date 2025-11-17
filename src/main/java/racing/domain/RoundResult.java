package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<Integer> roundResult;

    public RoundResult(Cars cars) {
        this(toList(cars));
    }

    public RoundResult(List<Integer> roundResult) {
        this.roundResult = roundResult;
    }

    private static List<Integer> toList(Cars cars) {
        List<Integer> roundResult = new ArrayList<>();

        for (Car car : cars.getCars()) {
            roundResult.add(car.getPosition());
        }
        return roundResult;
    }

    public List<Integer> getRoundResult() {
        return Collections.unmodifiableList(roundResult);
    }
}
