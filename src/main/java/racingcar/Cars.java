package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(CarNames carNames) {
        this.cars = carNames.generateCars();
    }

    public Cars(Car... cars) {
        this.cars = Arrays.stream(cars).collect(Collectors.toList());
    }

    public void move() {
        for (Car car : cars) {
            car.move(generateRandom());
        }
    }

    private int generateRandom() {
        return (int) (Math.random() * 10000) % 10;
    }


    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public String[] getWinners() {
        int maxPosition = maxPosition();

        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public List<String> getResult() {
        return cars.stream()
                .map(Car::statusToString)
                .collect(Collectors.toList());
    }






}
