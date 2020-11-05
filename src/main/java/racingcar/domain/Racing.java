package racingcar.domain;

import racingcar.common.Constants;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int numberOfTries;
    private List<Car> cars = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public Racing(int numberOfCars, int numberOfTries){
        this.numberOfTries = numberOfTries;
        for(int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public String race(RandomStrategyGenerator r) {
        for(int i = 0; i < numberOfTries; i++) {
            cars.stream().map(c -> c.move(r.generate())).forEach(sb::append);
            sb.append(Constants.NEW_LINE_DELIMITER);
        }
        return sb.toString();
    }
}
