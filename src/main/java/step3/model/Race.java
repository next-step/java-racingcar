package step3.model;

public class Race {

    private Cars cars;
    private Round round;

    public Race(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public void start() {
        round.start(cars);
    }
}
