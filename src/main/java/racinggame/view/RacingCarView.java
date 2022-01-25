package racinggame.view;

import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

public class RacingCarView {

    private RacingCar racingCar;

    public RacingCarView(RacingCar racingCar) {
        this.racingCar = racingCar;
    }

    public String drawCurrPosition() {
        String trace = Utils.repeat("-", this.racingCar.getPosition());
        return String.format("%-5s: %s\n", this.racingCar.getCarName(), trace);
    }
}
