package racingcar.step5.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private int maxDistance = 0;
    private List<Car> cars;
    private List<String> winners = new ArrayList<>();

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinnerList() {
        Collections.sort(cars);
        findWinners();
        return winners;

    }

    public void findWinners() {
        maxDistance = cars.get(0).getDistance();
        for (Car car : cars) {
            addWinner(car);
        }
    }

    public void addWinner(Car car) {
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
    }

}

