package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class MovingResult {

    private List<CarStateInRace> carsState = new ArrayList<>();

    private MovingResult() {
    }

    public static MovingResult instance() {
        return new MovingResult();
    }

    public void storeCurrentRoundStatement(final CarStateInRace carStateInRace) {
        carsState.add(carStateInRace);
    }

    public List<CarStateInRace> getCarsState() {
        return carsState;
    }
}
