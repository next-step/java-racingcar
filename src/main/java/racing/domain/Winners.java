package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    static final int WINNER_NUMBER = 0;

    private Cars cars;
    private List<String> winner = new ArrayList<>();

    public Winners(Cars cars) {
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
