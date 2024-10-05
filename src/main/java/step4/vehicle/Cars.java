package step4.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public static final int NUMBER_OF_PLAYERS = 2;

    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    public Cars(String[] names) {
        if (names.length < NUMBER_OF_PLAYERS) {
            throw new IllegalArgumentException("게임을 진행할 수 없음");
        }
        initCars(names);
    }

    private void initCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        int maxScore = cars.stream().mapToInt(Car::getLocation).max().getAsInt();
        return cars.stream()
                .filter(car -> car.getLocation() == maxScore)
                .collect(Collectors.toList());
    }

}
