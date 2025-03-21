package step5.racingcar3.domain;

import step5.racingcar3.exception.CarException;

public class Car {

    public final static int MIN_POSITION = 0;
    private final CarName carName;
    private final CarEngine carEngine;
    private int position;

    public Car(CarName carName, CarEngine carEngine) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = 0;
    }

    public Car(CarName carName, CarEngine carEngine, int position) {
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
            throw new CarException("자동차의 위치는 0 이상만 가능합니다.");
        }
    }

}
