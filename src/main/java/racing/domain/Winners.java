package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> cars;
    static final int WINNER_NUMBER = 0;

    List<String> winner = new ArrayList<>();

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> winners() {
        Collections.sort(cars);
        for (Car car : cars) {
            if (car.getMovingRange() == cars.get(WINNER_NUMBER).getMovingRange()) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
