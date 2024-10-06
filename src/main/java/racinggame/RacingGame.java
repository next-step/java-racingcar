package racinggame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = Cars.of(carCount);
    }
}
