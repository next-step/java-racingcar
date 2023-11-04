package study.racingcar;

public class Round {

    private final Cars participateCars;

    public Round(Cars cars) {
        this.participateCars = cars;
    }

    public void race() {
        participateCars.carlist().forEach(Car::run);
    }

}
