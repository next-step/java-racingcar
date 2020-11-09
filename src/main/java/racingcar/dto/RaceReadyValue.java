package racingcar.dto;

import java.util.Arrays;

public class RaceReadyValue {

    private static final String REGEX_COMMA = ",";
    private static final int CAR_NAME_MAXIMUM_LENGTH = 5;
    private static final String ERROR_MESSAGE_OVER_SIZE_CAR_NAME = "자동차 이름이 사이즈를 초과했습니다.";

    private final String[] carNames;
    private final int tryCount;

    private RaceReadyValue(String carNameList, int tryCount) {
        this.carNames = parseCarName(carNameList);
        this.tryCount = tryCount;
    }

    public static RaceReadyValue of(String carNameList, int tryCount) {
        validate(carNameList);

        return new RaceReadyValue(carNameList, tryCount);
    }

    private static void validate(String carNameList) {
        Arrays.stream(parseCarName(carNameList))
                .forEach(v -> {
                    if (v.length() > CAR_NAME_MAXIMUM_LENGTH)
                        throw new IllegalArgumentException(ERROR_MESSAGE_OVER_SIZE_CAR_NAME);
                });
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
