package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public void initializeCars(int numberOfCars){
        for(int i = 0; i < numberOfCars; i++)
            cars.add(new Car());
    }

    public String race(int numberOfTries) {
        for(int i = 0; i < numberOfTries; i++) {
            cars.stream().map(c -> c.move(5)).forEach(sb::append);
            sb.append("\n");
        }
        return sb.toString();
    }
}
