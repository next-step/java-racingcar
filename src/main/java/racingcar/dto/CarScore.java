package racingcar.dto;

import racingcar.domain.RacingCar;

public class CarScore {

    private String name;

    private int travelledDistance;

    public CarScore(String name, int travelledDistance) {
        this.name = name;
        this.travelledDistance = travelledDistance;
    }

    public CarScore(RacingCar racingCar) {
        this(racingCar.getName(),racingCar.getTravelledDistance());
    }

    public String getName() {
        return name;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }
}
