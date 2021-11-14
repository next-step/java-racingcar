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

    public Cars move(IntNumberGenerator generator) {
        return cars.move(generator);
    }
}
