package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners() {
        this.winners = new ArrayList<>();
    }

    public void add(Car car, Distance winDistance) {
        if (car.isWinner(winDistance)) {
            this.winners.add(car);
        }
    }

    public List<String> getNameStrings() {
        List<String> names = new ArrayList<>();
        for (Car winner : winners) {
            names.add(winner.getName().get());
        }
        return names;
    }

}
