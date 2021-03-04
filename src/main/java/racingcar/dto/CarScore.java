package racingcar.dto;

import racingcar.domain.RacingCar;

public class CarScore {

    private int travelledDistance;

    public CarScore(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public CarScore(RacingCar racingCar) {
        this(racingCar.getTravelledDistance());
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }
}
