package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winners {
    private List<Car> cars;
    static final int WINNER_NUMBER = 0;

    public Winners(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> winners() {
        Collections.sort(cars);
        List<String> winner = new ArrayList<>();
        winner.add(cars.get(WINNER_NUMBER).getName());
        for (int i = 1; i < cars.size(); i++) {
            if (cars.get(i).getMovingRange() == cars.get(WINNER_NUMBER).getMovingRange()) {
                winner.add(cars.get(i).getName());
            }
        }
        return winner;
    }
}
