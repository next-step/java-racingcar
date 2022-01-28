package racinggame.view;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.RacingCar;
import racinggame.domain.Utils;

public class CarResultView {

    private static final String FOOTPRINTS = "-";

    private RacingCar racingCar;
    private int currPosition;
    private String currResult;

    private CarResultView(RacingCar racingCar) {
        this.racingCar = racingCar;
        this.currPosition = racingCar.getPosition();
        this.currResult = String.format("%-5s: %s",
                racingCar.getCarName(),
                Utils.repeat(FOOTPRINTS, racingCar.getPosition()));
    }

    public static List<CarResultView> racingCarOf(List<RacingCar> racingCars) {
        return racingCars.stream()
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
