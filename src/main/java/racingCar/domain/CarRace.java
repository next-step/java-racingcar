package racingCar.domain;

import java.util.List;

public class CarRace {
    private final Cars cars;
    private RoundCount roundCount;

    public CarRace(String[] names, int roundCount) {
        this(new Cars(names), new RoundCount(roundCount));
    }

    public CarRace(Cars cars, RoundCount roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public List<Car> getCars() {
        return this.cars.value();
    }

    public void play() {
        this.cars.play();
        this.roundCount = roundCount.decrease();
    }

    public Winners getWinners() {
        return cars.getWinners();
    }

    public boolean hasNextRound() {
        return roundCount.hasNextRound();
    }
}
