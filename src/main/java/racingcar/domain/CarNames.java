package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CarNames {
    private static final Pattern CAR_NAMES_DELIMITER = Pattern.compile("[,]");
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    
    private final String[] names;

    public CarNames(String[] names) {
        this.names = names.clone();
    }

    public static CarNames of(String names) {
        String[] carNames = carNames(names);
        for (String carName : carNames) {
            if (isInvalidCarName(carName)) {
                throw new IllegalArgumentException("The car name is at least " + MIN_CAR_NAME_LENGTH + " characters and up to " + MAX_CAR_NAME_LENGTH + " characters.");
            }
        }
        return new CarNames(carNames);
    }

    private static String[] carNames(String names) {
        return CAR_NAMES_DELIMITER.split(names.replaceAll("\\s+",""));
    }

    private static boolean isInvalidCarName(String carName) {
        return carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH;
    }

    public int carCount() {
        return names.length;
    }

    public Cars createCars() {
        List<Car> cars = new ArrayList<>();
        for (String name: names) {
            cars.add(new Car(name));
        }
        return new Cars(cars);
    }
}
