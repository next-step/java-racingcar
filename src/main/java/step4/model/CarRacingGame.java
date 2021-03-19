package step4.model;

public class CarRacingGame {
    private final Cars cars;
    private final RemainingRound remainingRound;
    private MoveStrategy moveStrategy;

    public CarRacingGame(String[] carNames, int remainingRound, MoveStrategy moveStrategy) {
        this.cars = new Cars(carNames);
        this.remainingRound = new RemainingRound(remainingRound);
        this.moveStrategy = moveStrategy;
    }

    public void race() {
        remainingRound.race();
        cars.move(this.moveStrategy);
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
