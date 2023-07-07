package racingcar.controller.request;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RacingGamePlayControllerRequest)) {
            return false;
        }
        RacingGamePlayControllerRequest that = (RacingGamePlayControllerRequest) o;
        return round == that.round && Objects.equals(carNames, that.carNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round, carNames);
    }

    @Override
    public String toString() {
        return "RacingGamePlayControllerRequest{" +
            "round=" + round +
            ", carNames=" + carNames +
            '}';
    }
}
