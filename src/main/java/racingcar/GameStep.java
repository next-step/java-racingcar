package racingcar;

public class GameStep {
    private final CarStateList carStateList;

    private GameStep(CarStateList carStateList) {
        this.carStateList = carStateList;
    }

    public CarStateList getCarStateList() {
        return this.carStateList;
    }

    public static GameStep createGameStep(CarStateList carStateList) {
        return new GameStep(carStateList);
    }
}
