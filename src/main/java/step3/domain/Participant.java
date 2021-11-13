package step3.domain;

import step3.service.IntNumberGenerator;

public class Participant {
    private Cars cars;

    private Participant() {
    }

    private Participant(Cars cars) {
        this.cars = cars;
    }

    public static Participant join(String names) {
        return new Participant(Cars.create(names));
    }

    public RoundHistory move(IntNumberGenerator generator) {
        return new RoundHistory(cars.move(generator));
    }
}
