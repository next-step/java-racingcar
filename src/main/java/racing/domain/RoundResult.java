package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

    private final List<Integer> roundResult;

    public RoundResult(Cars cars) {
        List<Integer> roundResult = new ArrayList<>();

        for (Car car : cars.getCars()) {
            roundResult.add(car.getPosition());
        }
        this.roundResult = roundResult;
    }

    public List<Integer> getRoundResult() {
        return roundResult;
    }
}
