package step5.racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundResult {

    private final List<CarResult> carResults;

    public RoundResult(List<CarResult> carResults) {
        this.carResults = carResults;
    }

    public List<CarResult> getRoundResult() {
        return Collections.unmodifiableList(carResults);
    }

    public List<CarResult> winners() {
        List<CarResult> winners = new ArrayList<>();

        Position maxPosition = maxPosition();

        for (CarResult carResult : carResults) {
            if (carResult.isMaxPosition(maxPosition)) {
                winners.add(carResult);
            }
        }
        return winners;
    }

    private Position maxPosition() {
        Position maxPosition = new Position(0);

        for (CarResult carResult : carResults) {
            maxPosition = maxPosition.biggerPosition(carResult.position());
        }
        return maxPosition;
    }
}
