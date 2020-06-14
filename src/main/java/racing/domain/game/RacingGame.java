package racing.domain.game;

import racing.domain.car.CarForwardBehavior;
import racing.domain.car.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCars> race(int times) {
        List<RacingCars> racingCarsList = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            RacingCars racingCars = this.racingCars.moveCars(new CarForwardBehavior());
            racingCarsList.add(racingCars);
        }
        return racingCarsList;
    }

    public int findMaxPosition() {
        return racingCars.findMaxPosition();
    }

    public static List<String> findWinnerCars(RacingCars racingCars, int maxCarPosition) {
        return racingCars.findWinnersCars(racingCars.getCars(), maxCarPosition);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

}
