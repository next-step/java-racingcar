package racingcarwinner.service;

public class ParticipatedCarsUtils {
    private static final String DELIMITER = ",";
    private String[] carNames;

    public ParticipatedCarsUtils(String carNames) {
        this.carNames = setSplitCarNames(carNames);
    }

    private String[] setSplitCarNames(String carNames) {
        return carNames.split(DELIMITER);
    }

    public String[] getCarNames() {
        return carNames;
    }
}
