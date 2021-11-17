package racing.basic.domain;

import java.util.Arrays;
import java.util.List;

public class CarRacingGame {

    private final List<Car> cars;

    public CarRacingGame(int lineCount) {
        Car[] carBuffer = new Car[lineCount];
        for (int i = 0; i < lineCount; i++) {
            carBuffer[i] = new Car();
        }
        cars = Arrays.asList(carBuffer);
    }

    public int[] nextRound(int[] diceNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.moveOrStop(diceNumbers[i]);
        }
        return displayTrack();
    }

    private int[] displayTrack() {
        return cars.stream()
                .mapToInt(Car::getDrivingDistance)
                .toArray();
    }
}
