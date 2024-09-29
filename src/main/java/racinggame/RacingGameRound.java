package racinggame;

import racinggame.utils.RacingGameUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameRound {
    private final List<RacingCar> racingCars;
    private final Map<RacingCar, Boolean> racingCarMoveStatusMap;

    public RacingGameRound(final List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        this.racingCarMoveStatusMap = new HashMap<>();
    }

    public void start() {
        for (final RacingCar racingCar : racingCars) {
            final boolean move = racingCar.move(RacingGameUtils.generateRandomNumber());
            racingCarMoveStatusMap.put(racingCar, move);
        }
    }

    public boolean isMove(final RacingCar racingCar) {
        return racingCarMoveStatusMap.getOrDefault(racingCar, false);
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
