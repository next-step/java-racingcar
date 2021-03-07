package racingcar.dto;

import racingcar.domain.RacingCar;

public class CarScore {

    private String carName;

    private int travelledDistance;

    public CarScore(int travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public CarScore(RacingCar racingCar) {
        this(racingCar.getName(), racingCar.getTravelledDistance());
    }

    public CarScore(String carName, int travelledDistance) {
        this.carName = carName;
        this.travelledDistance = travelledDistance;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }

    public String getCarName() {
        return carName;
    }

    public boolean isMatch(int maxTravelledDistance) {
        return travelledDistance == maxTravelledDistance;
    }
}
