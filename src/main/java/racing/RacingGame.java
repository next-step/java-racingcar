package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int time;
    private int racingCount = 0;
    private List<Car> cars = new ArrayList<>();

    public RacingGame(int time, int cars) {
        this.validateRacingCar(time, cars);
        this.time = time;
        CarMovement carMovement = new RandomMovement(new Random());
        for (int i = 0; i < cars; i++) {
            this.cars.add(new Car(carMovement));
        }
    }

    private void validateRacingCar(int time, int cars) {
        if (time < 1) {
            throw new IllegalArgumentException();
        }

        if (cars < 1) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> startRacing() {
        while (this.time > this.racingCount) {
            this.cars.stream()
                    .forEach(car -> car.move());
            this.racingCount++;
        }

        return this.cars;
    }

    public int racingCount() {
        return this.racingCount;
    }
}
