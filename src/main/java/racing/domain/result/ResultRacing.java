package racing.domain.result;

import racing.domain.car.Cars;

public class ResultRacing {
    private Cars cars;
    private int round;

    public ResultRacing(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public Cars getCars() {
        return cars;
    }
}
