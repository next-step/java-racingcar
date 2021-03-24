package carRacing.model;

import carRacing.util.RandomIntUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Cars {
    final static String DELIMITER = ",";
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Cars getWinners() {
        return new Cars(getWinners(getMaxScore()));
    }

    private List<Car> getWinners(int maxScore) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxScore)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxScore() {
        int maxScore = 0;
        for (Car car : cars) {
            if (maxScore < car.getPosition()) {
                maxScore = car.getPosition();
            }
        }
        return maxScore;
    }

    public void excuteCycle() {
        for (Car car : cars) {
            car.moveByRandomInt(RandomIntUtil.getRandomInt());
        }
    }

    public void enrollCars(String carNames) {
        String[] carNameList = carNames.split(DELIMITER);
        Arrays.stream(carNameList).forEach(carName -> this.cars.add(new Car(carName)));
    }

    public String getNameList() {
        return String.join(DELIMITER, cars.stream().map(Car::getCarName).toArray(String[]::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        StringBuilder carsString = new StringBuilder();
        for (Car car : cars) {
            carsString.append(car);
            carsString.append("\n");
        }
        return carsString.toString();
    }

}
