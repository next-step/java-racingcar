package camp.nextstep.edu.racingcar.domain;

public class Round {
    private final Cars cars;

    private Round(Cars cars) {
        assert cars != null;
        this.cars = cars;
    }

    public static Round initialRoundFrom(CarNames carNames) {
        final Cars initialCars = Cars.defaultInstance(carNames);
        return new Round(initialCars);
    }

    public Cars getCars() {
        return cars;
    }

    public Round move(MovingStrategy movingStrategy) {
        final Cars movedCars = cars.move(movingStrategy);
        return new Round(movedCars);
    }

    // TODO: toString
    // TODO: equal
    // TODO: hashcode
}
