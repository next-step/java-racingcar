package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String[] names) {
        this.cars = joinCars(names);
    }

    private List<Car> joinCars(String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public List<Car> move(CarMovementStrategy carMovementStrategy) {
        List<Car> copiedCars = new ArrayList<>(cars);

        for (Car car : copiedCars) {
            car.move(carMovementStrategy);
        }

        return copiedCars;
    }

    public List<String> getTheHighestScoreDrivers() {
        int maxScore = getTheHighestScore();
        return getDriversWithTopScore(maxScore);
    }

    private int getTheHighestScore() {
        int maxScore = 0;

        for (Car car : cars) {
            maxScore = car.getScoreGreaterThan(maxScore);
        }

        return maxScore;
    }

    private List<String> getDriversWithTopScore(int maxScore) {
        List<String> topScoreDrivers = cars.stream()
                .filter(car -> car.isWinner(maxScore))
                .map(Car::getName)
                .collect(Collectors.toList());

        return topScoreDrivers;
    }

}
