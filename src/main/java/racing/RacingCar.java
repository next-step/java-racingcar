package racing;

import racing.util.RandomDistance;
import racing.view.RacingView;

public class RacingCar {
    private final int attempt;
    private final int[] cars;

    private final RacingView racingView = new RacingView();

    public RacingCar(int numberOfCar, int attempt) {
        this.cars = new int[numberOfCar];
        this.attempt = attempt;
    }

    public void play() {
        for (int i = 0; i < attempt; i++) {
            moveCar();
        }
    }

    private void moveCar() {
        for (int i = 0; i < cars.length; i++) {
            final int currentLocation = cars[i] + RandomDistance.getMoveDistance();
            cars[i] = currentLocation;
        }
        racingView.print(cars);
    }
}
