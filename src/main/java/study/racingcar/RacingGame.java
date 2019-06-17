package study.racingcar;

import study.racingcar.creator.RacingCarCreator;
import study.racingcar.model.Car;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class RacingGame {
    private final int carCount;
    private final int time;
    private final RacingCarCreator carCreator;

    public RacingGame(int carCount, int time,
                      RacingCarCreator carCreator) {
        this.carCount = carCount;
        this.time = time;
        this.carCreator = carCreator;
    }

    public void start() {
    }

    private List<Car> makeRacingCar() {
        return RacingCarCreator.create(this.carCount);
    }
}
