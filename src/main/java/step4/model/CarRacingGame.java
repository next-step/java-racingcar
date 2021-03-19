package step4.model;

public class CarRacingGame {
    private final Cars cars;
    private final RemainingRound remainingRound;

    public CarRacingGame(String[] carNames, int remainingRound) {
        this.cars = new Cars(carNames);
        this.remainingRound = new RemainingRound(remainingRound);
    }

    public void race(MoveStrategy moveStrategy) {
        remainingRound.race();
        cars.move(moveStrategy);
    }

    public boolean racing() {
        return remainingRound.racing();
    }

    public Cars Cars() {
        return this.cars;
    }
    public Winners Winners() {
        return cars.Winners();
    }


}
