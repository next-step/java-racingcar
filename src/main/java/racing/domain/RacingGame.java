package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    public static final String SEPARATOR = ",";

    List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void repeatMoveCars(int count) {
        for (int i = 0; i < count; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public List<Car> findWinner() {
        List<Car> winnerCars = new ArrayList<>();
        int winnerPosition = findWinnePosition();

        for (Car car : this.cars) {
            if (car.isWinner(winnerPosition)) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }

    private int findWinnePosition() {
        int winnerPosition = 0;

        for (Car car : this.cars) {
            winnerPosition = Math.max(winnerPosition, car.getDistance());
        }

        return winnerPosition;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}