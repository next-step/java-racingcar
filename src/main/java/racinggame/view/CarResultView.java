package racinggame.view;

import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

public class CarResultView {

    private static final String FOOTPRINTS = "-";

    private RacingCar racingCar;
    private int currPosition;
    private String currResult;

    public CarResultView(RacingCar racingCar) {
        this.racingCar = racingCar;
        this.currPosition = racingCar.getPosition();
        this.currResult = String.format("%-5s: %s\n",
                racingCar.getCarName(),
                Utils.repeat(FOOTPRINTS, racingCar.getPosition()));
    }

    public String drawCurrResult() {
        currResult += Utils.repeat(FOOTPRINTS, countForward());
        return currResult;
    }

    private int countForward() {
        return racingCar.getPosition() - currPosition;
    }
}
