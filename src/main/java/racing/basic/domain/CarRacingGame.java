package racing.basic.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final List<Car> cars;

    public CarRacingGame(int lineCount) {
        Car[] carBuffer = new Car[lineCount];
        for (int i = 0; i < lineCount; i++) {
            carBuffer[i] = new Car();
        }
        cars = Arrays.asList(carBuffer);
    }

    public List<Integer> nextRound(List<Integer> diceNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int diceNumber = diceNumbers.get(i);
            car.moveOrStop(diceNumber);
        }
        return displayTrack();
    }

    private List<Integer> displayTrack() {
        return cars.stream()
                .map(Car::getDrivingDistance)
                .collect(
                        Collectors.toList()
                );
    }
}
