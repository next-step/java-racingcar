package racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int startRound = 1;
    private int finalRound;
    private int totalCar;

    private final List<Car> cars = new ArrayList<>();

    private RacingGame() { }

    public RacingGame(int finalRound, int totalCar) {
        this.finalRound = finalRound;
        this.totalCar = totalCar;
        for (int i = 1; i <= totalCar; i++) {
            cars.add(new Car(i));
        }
    }

    public boolean isEndGame() {
        return finalRound + 1 == startRound;
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public void roundUp() {
        startRound++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Car c : cars) {
            builder.append(c.toString());
            builder.append('\n');
        }
        return builder.toString();
    }
}
