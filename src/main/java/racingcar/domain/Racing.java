package racingcar.domain;

import racingcar.common.Constants;
import racingcar.common.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public Racing(int numberOfCars){
        for(int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public String race(int numberOfTries) {
        for(int i = 0; i < numberOfTries; i++) {
            cars.stream().map(c -> c.move(RandomNumberGenerator.generate())).forEach(sb::append);
            sb.append(Constants.NEW_LINE_DELIMITER);
        }
        return sb.toString();
    }
}
