package step4.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final List<Car> winners = new ArrayList<>();

    public Cars(String[] names) {
        if (names.length < 2) {
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

    public List<Car> getWinners() {
        int maxScore = cars.stream().mapToInt(Car::getLocation).max().getAsInt();
        findWinner(maxScore);
        return winners;
    }

    private void findWinner(int checkMax) {
        for (Car car : cars) {
            addWinner(checkMax, car);
        }
    }

    private void addWinner(int checkMax, Car car) {
        if (car.getLocation() == checkMax) {
            winners.add(car);
        }
    }

}
