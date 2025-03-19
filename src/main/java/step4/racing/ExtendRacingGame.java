package step4.racing;

import java.util.ArrayList;
import java.util.List;
import racing.Car;
import racing.RacingGame;

public class ExtendRacingGame extends RacingGame {

    public ExtendRacingGame(String carNames, int maxRandomNumber) {
        super(createCars(carNames), maxRandomNumber);
    }

    private static List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>(names.length);
        for (String name : names) {
            cars.add(new ExtendCar(name));
        }
        return cars;
    }

    public String[] carNames() {
        return cars.stream().map(Car::name).toArray(String[]::new);
    }

    public List<Car> cars() {
        return cars;
    }

    public List<String> winners() {
        int maxPosition = maxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.currentPosition() == maxPosition) {
                winners.add(car.name());
            }
        }
        return winners;
    }

    private int maxPosition() {
        return cars.stream()
            .mapToInt(Car::currentPosition)
            .max()
            .orElseThrow(IllegalStateException::new);
    }
}
