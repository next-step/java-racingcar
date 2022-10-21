package nextstep.javaracingcar.domain;

import nextstep.javaracingcar.domain.Round;

public class CarRacingGameInput {

    private final String carNames;
    private final Round round;

    public CarRacingGameInput(String carNames, int roundCount) {
        this.carNames = carNames;
        this.round = new Round(roundCount);
    }

    public String getCarNames() {
        return carNames;
    }

    public Round round() {
        return round;
    }
}
