package racingcar.domain;

public class StringUtils {

    private static final String DELIMITER = ",";

    private StringUtils() {
    }

    public static String[] splitCarNames(String carNames) {
        return carNames.split(DELIMITER);
    }

}
