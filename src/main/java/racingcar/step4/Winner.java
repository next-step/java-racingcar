package racingcar.step4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    List<String> winners = new ArrayList<>();
    private List<Car> cars;
    private int maxDistance = 0;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public void getWinnerList() {
        Collections.sort(cars);
        findWinners();
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

