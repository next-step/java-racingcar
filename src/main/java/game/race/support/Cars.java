package game.race.support;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import game.race.Car;
import game.race.support.move.MovePolicy;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public static Cars of(List<String> vehicleNames) {
        Cars cars = new Cars(new ArrayList<>());
        cars.getCarList().addAll(vehicleNames.stream().map(Car::new).collect(Collectors.toList()));

        return cars;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void move(MovePolicy policy) {
        for (Car car : carList) {
            car.move(policy);
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            addWinner(car, getMaxMoveCount(), winners);
        }

        return winners;
    }

    private int getMaxMoveCount() {
        int maxMoveCount = 0;
        for (Car car : carList) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        return maxMoveCount;
    }

    private void addWinner(Car car,
                           int maxMoveCount,
                           List<String> winners) {
        if (maxMoveCount == car.getMoveCount()) {
            winners.add(car.getName());
        }
    }
}
