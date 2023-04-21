package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public static final int WINNER_MIN_LOCATION = 0;

    private List<Car> cars = new ArrayList<>();

    public void readyCar(String[] carsName) {
        for (String name : carsName) {
            cars.add(new Car(name));
        }
    }

    public void playGame() {
        for (Car car : cars) {
            car.move(RandomNumberGenerator.randomNumber());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> racingWinner(List<Car> cars) {
        int winnerLocation = getWinnerLocation(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .collect(Collectors.toUnmodifiableList());
    }

    private static int getWinnerLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .reduce(WINNER_MIN_LOCATION, Math::max);
    }

}
