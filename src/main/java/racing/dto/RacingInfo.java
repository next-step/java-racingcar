package racing.dto;

import java.util.List;

public class RacingInfo {

    private static final int VALID_CAR_NAMES_COUNT = 1;
    static final int VALID_ATTEMPTS = 1;

    static final String CAR_NAMES_EXCEPTION_MESSAGE = String.format("차량이름 수는 %d 보다 커야 합니다.", VALID_CAR_NAMES_COUNT);
    static final String ATTEMPTS_EXCEPTION_MESSAGE = String.format("시도 횟수는 %d 보다 커야 합니다.", VALID_ATTEMPTS);

    private List<String> carNames;
    private int attempts;

    private RacingInfo() {}

    public static RacingInfo of(List<String> carNames, int attempts) {

        validateCarNames(carNames);
        validateAttempts(attempts);

        RacingInfo racingInfo = new RacingInfo();
        racingInfo.carNames = carNames;
        racingInfo.attempts = attempts;
        return racingInfo;
    }

    private static void validateCarNames(List<String> splitCarNames) {

        if (splitCarNames.size() < VALID_CAR_NAMES_COUNT) {
            throw new IllegalArgumentException(CAR_NAMES_EXCEPTION_MESSAGE);
        }
    }

    private static void validateAttempts(int attempts) {

        if (attempts < VALID_ATTEMPTS) {
            throw new IllegalArgumentException(ATTEMPTS_EXCEPTION_MESSAGE);
        }
    }

    public List<String> getCarNames() {

        return carNames;
    }

    public int getAttempts() {

        return attempts;
    }
}
