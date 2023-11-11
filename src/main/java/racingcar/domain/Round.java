package racingcar.domain;


public class Round {

    private Cars cars;

    public void recordRound(final Cars cars) {
        this.cars = cars;
    }

    public Cars getRoundCarStatus() {
        return cars;
    }

}
