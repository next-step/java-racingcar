package racingcarwinner.service;

public class ParticipatedCarsUtils {
    private static final String DELIMITER = ",";

    public static String[] splitCarNames(String carNames) {
        return carNames.split(DELIMITER);
    }

}
