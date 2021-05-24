package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    static final int WINNER_NUMBER = 0;

    private Cars cars;
    private List<String> winner;

    public Winners(Cars cars) {
        this.cars = cars;
        this.winner = winners();
    }

    public List<String> winners() {
        Collections.sort(cars.getCars());
        List<String> winner = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getMovingRange() == cars.getCars().get(WINNER_NUMBER).getMovingRange()) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}
