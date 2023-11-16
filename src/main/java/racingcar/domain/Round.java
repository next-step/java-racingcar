package racingcar.domain;


public class Round {

    private final Cars cars;

    public Round(Cars cars) {
        this.cars = cars;
    }

    public Cars getRoundCarStatus() {
        return cars;
    }

}
