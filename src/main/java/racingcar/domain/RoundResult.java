package racingcar.domain;

import java.util.List;

public class RoundResult {
    private Attempt roundNumber;
    private List<Car> carStatus;

    public RoundResult(Attempt roundNumber, List<Car> carStatus) {
        this.roundNumber = roundNumber;
        this.carStatus = carStatus;
    }

    public List<Car> getCarStatus() {
        return carStatus;
    }
}