package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private final List<Car> cars;
    private List<String> winners = new ArrayList<>();


    public CarManager(List<Car> cars) {
        this.cars = cars;
    }


    public List<Car> getCars() {
        return cars;
    }

    public List<String> findWinner() {
        winners.clear();

        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = car.max(maxPosition);

            addWinner(car, maxPosition);
        }

        return winners;
    }

    private void addWinner(Car car, int maxPosition) {
        if(car.isWineer(maxPosition)){
            winners.add(car.getName());
        }
    }
}