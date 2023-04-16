package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final String MIN_LENGTH_FORNAT = "자동차는 %s개 이상이여야 합니다.";
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;

    private List<Car> cars = new ArrayList<>();

    public Cars(final String carNames) {
        generate(split(carNames));
    }

    private String[] split(final String carNames) {
        return carNames.split(DELIMITER);
    }

    private void generate(final String[] carNames) {
        validate(carNames);
        for (String carName : carNames) {
            cars.add(new Car(carName, new RandomNumberGenerator()));
        }
    }

    private void validate(final String[] carNames) {
        if (carNames.length < MIN_NUMBER) {
            throw new IllegalArgumentException(String.format(MIN_LENGTH_FORNAT, MIN_NUMBER));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
