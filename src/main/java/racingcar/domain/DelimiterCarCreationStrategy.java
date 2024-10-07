package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterCarCreationStrategy implements CarCreationStrategy {
    public static final String DELIMITER = ",";

    @Override
    public List<Car> create(String names) {
        List<Car> cars = new ArrayList<>();
        String[] split = names.split(DELIMITER);
        for (String name : split) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
