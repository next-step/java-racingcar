package racinggame.view;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.Utils;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;

public class CarResultView {

    private static final String FOOTPRINTS = "-";

    private final RacingCar racingCar;
    private int currPosition;
    private String currResult;

    private CarResultView(final RacingCar racingCar) {
        this.racingCar = racingCar;
        this.currPosition = racingCar.getPosition();
        this.currResult = String.format("%-5s: %s",
                racingCar.getName(),
                Utils.repeat(FOOTPRINTS, racingCar.getPosition()));
    }

    public static List<CarResultView> racingCarOf(final RacingCars racingCars) {
        return racingCars.get().stream()
                .map(CarResultView::new)
                .collect(Collectors.toList());
    }

    public String drawCurrResult() {
        currResult += Utils.repeat(FOOTPRINTS, countForward());
        return currResult;
    }

    private int countForward() {
        return racingCar.getPosition() - currPosition;
    }
}
