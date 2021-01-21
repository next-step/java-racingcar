package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> cars;
    private MoveChecker moveChecker;

    public Cars(final List<Car> cars, MoveChecker moveChecker) {
        this.cars = cars;
        this.moveChecker = moveChecker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars) && moveChecker.equals(cars1.moveChecker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, moveChecker);
    }

    public void doRound() {
        for (Car car : cars) {
            car.play(moveChecker);
            car.printNameAndCurrentPosition();
        }
        System.out.println();
    }

    public void printWinners() {
        List<String> winners = getWinners();
        System.out.println(String.join(", ", winners));
    }

    private List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int farthest = getFarthestLocation();
        for (Car car : cars) {
            addIfEqualLocation(winners, car, farthest);
        }
        return winners;
    }

    private int getFarthestLocation() {
        int farthestLocation = 0;
        for (Car car : cars) {
            farthestLocation = max(farthestLocation, car);
        }
        return farthestLocation;
    }

    private int max(int farthestLocation, final Car car) {
        if (car.getLocation() > farthestLocation) {
            farthestLocation = car.getLocation();
        }
        return farthestLocation;
    }

    private void addIfEqualLocation(List<String> winners, Car car, int farthest) {
        if (car.getLocation() == farthest) {
            winners.add(car.getName());
        }
    }
}
