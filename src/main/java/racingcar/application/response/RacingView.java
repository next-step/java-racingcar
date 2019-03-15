package racingcar.application.response;

import racingcar.domain.RacingCars;

public class RacingView {
    private final int time;
    private final RacingCars racingCars;

    public RacingView(final int time, final RacingCars racingCars) {
        this.time = time;
        this.racingCars = racingCars;
    }

    public int getTime() {
        return time;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }
}
