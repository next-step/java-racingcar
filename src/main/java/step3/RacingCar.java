package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private final List<String> status;

    public static RacingCar create() {
        return new RacingCar();
    }

    private RacingCar() {
        status = new ArrayList<>();
        status.add("-");
    }

    public RacingCar doMoveOrStop() {
        if (RandomMoveDeterminator.doMoving()) return move();
        return stop();
    }

    public RacingCar move() {
        status.add("-");
        return this;
    }

    public String getStatus() {
        StringBuilder statusBuilder = new StringBuilder();
        status.forEach(statusBuilder::append);
        return statusBuilder.toString();
    }

    public RacingCar stop() {
        return this;
    }
}
