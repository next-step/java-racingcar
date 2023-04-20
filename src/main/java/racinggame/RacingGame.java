package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class RacingGame {
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

    public static List<Car> racingWinner(List<Car> cars) {
        int winnerLocation = getWinnerLocation(cars);
        return cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .collect(Collectors.toList());
    }

    private static int getWinnerLocation(List<Car> cars) {
        int max = cars.get(0).getLocation();
        for (int i = 1; i < cars.size(); i++) {
            int current = cars.get(i).getLocation();
            if (current > max) {
                max = current;
            }
        }
        return max;
    }


}
