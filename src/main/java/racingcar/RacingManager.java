package racingcar;

public class RacingManager {

    private final Cars cars;
    private final int round;

    public RacingManager(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public void play() {
        for (int i = 0; i < round; i++) {
            cars.takeTurn();
        }
    }
}
