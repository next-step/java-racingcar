package carRacing.domain;

import carRacing.util.MoveStrategy;
import carRacing.util.NumberGenerator;

import java.util.List;

public class Round {
    private final Cars cars;

    public Round(String[] nameArray, MoveStrategy moveStrategy) {
        this.cars = new Cars(nameArray, moveStrategy);
    }

    public List<Car> play(NumberGenerator numberGenerator) {
        cars.move(numberGenerator);
        return cars.getCarsForPrint();
    }

    public List<String> callWinners() {
        return cars.findWinners();
    }


}
