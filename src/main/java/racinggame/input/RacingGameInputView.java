package racinggame.input;

import racinggame.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameInputView {
    private final RacingCarInput carInput;
    private final RacingTryCountInput tryCountInput;

    public RacingGameInputView(final RacingCarInput carInput, final RacingTryCountInput tryCountInput) {
        this.carInput = carInput;
        this.tryCountInput = tryCountInput;
    }

    public List<RacingCar> createRacingCars() {
        final List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < carInput.getCarCount(); i++) {
            racingCars.add(new RacingCar(tryCountInput));
        }
        return racingCars;
    }
}
