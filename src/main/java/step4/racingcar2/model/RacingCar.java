package step4.racingcar2.model;

import step4.racingcar2.exception.RacingCarException;

public class RacingCar {

    public final static int MIN_POSITION = 0;
    private final RacingCarName carName;
    private final RacingCarEngine carEngine;
    private int position;

    public RacingCar(RacingCarName carName, RacingCarEngine carEngine) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = 0;
    }

    public RacingCar(RacingCarName carName, RacingCarEngine carEngine, int position) {
        validate(position);
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = position;
    }

    public int position() {
        return this.position;
    }

    public String name() {
        return this.carName.value();
    }

    public void run() {
        if (carEngine.canRun()) {
            this.position++;
        }
    }

    public void validate(int position) {
        if (position < MIN_POSITION) {
            throw new RacingCarException("자동차의 위치는 0 이상만 가능합니다.");
        }
    }

}
