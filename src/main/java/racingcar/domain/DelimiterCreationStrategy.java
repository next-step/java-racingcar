package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class DelimiterCreationStrategy implements CreationStrategy {
    public static final String DELIMITER = ",";

    @Override
    public Cars create(final String names) {
        List<Car> cars = new ArrayList<>();
        String[] split = names.split(DELIMITER);
        for (String name : split) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
