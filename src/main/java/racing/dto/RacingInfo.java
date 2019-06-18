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

        if (!isValidCarNames(carNames)) {
            throw new IllegalArgumentException(CAR_NAMES_EXCEPTION_MESSAGE);
        }
        if (!isValidAttempts(attempts)) {
            throw new IllegalArgumentException(ATTEMPTS_EXCEPTION_MESSAGE);
        }

        RacingInfo racingInfo = new RacingInfo();
        racingInfo.carNames = carNames;
        racingInfo.attempts = attempts;
        return racingInfo;
    }

    private static boolean isValidCarNames(List<String> splitCarNames) {

        return splitCarNames.size() >= VALID_CAR_NAMES_COUNT;
    }

    private static boolean isValidAttempts(int attempts) {

        return attempts >= VALID_ATTEMPTS;
    }

    public List<String> getCarNames() {

        return carNames;
    }

    public int getAttempts() {

        return attempts;
    }
}
