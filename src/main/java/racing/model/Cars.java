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

    public List<Car> moveOrNot(CarMovementStrategy carMovementStrategy) {
        for (Car car : cars) {
            car.move(carMovementStrategy);
        }
        return cars;
    }

    public List<Car> getTheHighestScoreDrivers() {
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

    private List<Car> getDriversWithTopScore(int maxScore) {
        List<Car> topScores = cars.stream()
                .filter(car -> car.isWinner(maxScore))
                .collect(Collectors.toList());

        return topScores;
    }

}
