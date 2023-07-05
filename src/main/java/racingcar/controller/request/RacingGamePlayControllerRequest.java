package racingcar.controller.request;

import java.util.List;

public class RacingGamePlayControllerRequest {

    private final int round;
    private final List<String> carNames;

    public RacingGamePlayControllerRequest(int round, List<String> carNames) {
        this.round = round;
        this.carNames = carNames;
    }

    public int getRound() {
        return round;
    }

    public List<String> getCarNames() {
        return carNames;
    }

}
