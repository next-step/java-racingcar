package camp.nextstep.edu.racingcar.view.dto;

import camp.nextstep.edu.racingcar.domain.CarNames;

public class GameRequest {
    private final CarNames carNames;
    private final int numberOfRounds;

    private GameRequest(CarNames carNames, int numberOfRounds) {
        this.carNames = carNames;
        this.numberOfRounds = numberOfRounds;
    }

    public static GameRequest of(CarNames carNames, int numberOfRounds) {
        return new GameRequest(carNames, numberOfRounds);
    }

    public CarNames getCarNames() {
        return carNames;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    // TODO: toString
    // TODO: equal
    // TODO: hashcode
}
