package racingcar.dto;

import racingcar.validator.InputValidator;

public class RaceReadyValue {

    private static final String REGEX_COMMA = ",";

    private final String[] carNames;
    private final int tryCount;

    private RaceReadyValue(String carNameList, int tryCount) {
        this.carNames = parseCarName(carNameList);
        this.tryCount = tryCount;
    }

    public static RaceReadyValue of(String carNameList, int tryCount) {
        InputValidator.validate(carNameList);

        return new RaceReadyValue(carNameList, tryCount);
    }

    private static String[] parseCarName(String carNameList) {
        return carNameList.split(REGEX_COMMA);
    }

    public String[] getCarNames() {
        return this.carNames;
    }

    public int getTryCount() {
        return this.tryCount;
    }
}
