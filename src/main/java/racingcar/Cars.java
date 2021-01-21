package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars = new ArrayList<>();
    private final MoveChecker moveChecker;

    public Cars(final List<String> cars, final MoveChecker moveChecker) {
        for (String car : cars) {
            this.cars.add(new Car(car, 0));
        }
        this.moveChecker = moveChecker;
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
        System.out.println("최종 우승자: " + String.join(", ", winners));
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
