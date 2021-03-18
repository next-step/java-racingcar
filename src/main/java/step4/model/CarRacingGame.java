package step4.model;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(String[] carNames, int round) {
        this.cars = new Cars(carNames);
        this.round = new Round(round);
    }

    public void race(MoveStrategy moveStrategy) {
        round.race();
        cars.move(moveStrategy);
    }

    public boolean racing() {
        return round.racing();
    }

    public Cars Cars() {
        return this.cars;
    }
    public Winners Winners() {
        return cars.Winners();
    }


}
