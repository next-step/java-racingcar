package racingcar.service;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCar {
    private final int ZERO = 0;
    private final String DELIMITER = ",";
    private final List<Car> cars;

    private Move move;

    public RacingCar(String nameOfCars, Move move) {
        this.cars = registerCar(splitCarName(nameOfCars));
        this.move = move;
    }

    private List<Car> registerCar(String[] nameOfCars) {
        return Arrays.stream(nameOfCars).map(Car::new).collect(Collectors.toList());
    }

    public void start(List<Integer> randomList) {
        for(int i = 0; i < cars.size(); i++) {
            this.move(cars.get(i), randomList.get(i));
        }
    }

    private void move(Car car, int number) {
        if (move.goOrStop(number)) {
            car.drive();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinner() {
        int max = cars.stream().max(Comparator.comparing(Car::getDistance)).get().getDistance();
        return cars.stream().filter(car -> car.getDistance() == max).map(Car::getName).collect(Collectors.toList());
    }

    private String[] splitCarName(String nameOfCars) {
        if (nameOfCars.length() == ZERO) {
            throw new RuntimeException("player zero");
        }

        return nameOfCars.split(DELIMITER);
    }
}
