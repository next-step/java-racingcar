package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars = new ArrayList<>();
    private static final CarMovementStrategy carMovementStrategy = new RandomMovementStrategy();

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

    public List<Car> getCurrentSituation() {
        return move();
    }

    private List<Car> move() {
        for (Car car : cars) {
            car.move(carMovementStrategy);
        }
        return cars;
    }

    public String getWinnerNames() {
        List<Car> topScores = getTheHighestScoreDrivers(cars);

        String winnerNames = topScores.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return winnerNames;
    }

    private List<Car> getTheHighestScoreDrivers(List<Car> cars) {
        int maxScore = getTheHighestScore(cars);

        List<Car> topScores = cars.stream()
                .filter(car -> car.isWinner(maxScore))
                .collect(Collectors.toList());

        return topScores;
    }

    private int getTheHighestScore(List<Car> cars) {
        int maxScore = 0;

        for (Car car : cars) {
            maxScore = car.getScoreGreaterThan(maxScore);
        }

        return maxScore;
    }

}
