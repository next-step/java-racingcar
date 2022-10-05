package racingcar.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Pattern;

import racingcar.domain.exception.InvalidCarNameException;

public class CarNames implements Iterable<String> {
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
            checkCarName(carName);
        }
        return new CarNames(carNames);
    }

    private static void checkCarName(String carName) {
        if (isInvalidCarName(carName)) {
            throw new InvalidCarNameException(MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH);
        }
    }

    public int carCount() {
        return names.length;
    }
    
    private static String[] carNames(String names) {
        return CAR_NAMES_DELIMITER.split(names.replaceAll("\\s+",""));
    }

    private static boolean isInvalidCarName(String carName) {
        return carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH;
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.asList(names).iterator();
    }
}
