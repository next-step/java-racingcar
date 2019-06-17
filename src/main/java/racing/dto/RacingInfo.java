package racing.dto;

import racing.util.StringUtil;

import java.util.List;

public class RacingInfo {

    static final int VALID_CAR_COUNT = 1;
    static final int VALID_ATTEMPTS = 1;

    static final String CAR_COUNT_EXCEPTION_MESSAGE = String.format("차량 개수는 %d 보다 커야 합니다.", VALID_CAR_COUNT);
    static final String ATTEMPTS_EXCEPTION_MESSAGE = String.format("시도 횟수는 %d 보다 커야 합니다.", VALID_ATTEMPTS);
    private static final String CAR_NAMES_DELIMITER = ",";

    private List<String> carNames;
    private int carCount;
    private int attempts;

    public RacingInfo(List<String> carNames, int attempts) {

        this.carNames = carNames;
        this.attempts = attempts;
    }

    private RacingInfo(int carCount, int attempts) {

        this.carCount = carCount;
        this.attempts = attempts;
    }

    public static RacingInfo of(int carCount, int attempts) {

        if (carCount < VALID_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEPTION_MESSAGE);
        }
        if (attempts < VALID_ATTEMPTS) {
            throw new IllegalArgumentException(ATTEMPTS_EXCEPTION_MESSAGE);
        }

        return new RacingInfo(carCount, attempts);
    }

    public static RacingInfo of(String carNames, int attempts) {

        List<String> tokenizedCarNames = StringUtil.tokenize(carNames, CAR_NAMES_DELIMITER);
        if (tokenizedCarNames.size() < VALID_CAR_COUNT) {
            throw new IllegalArgumentException(CAR_COUNT_EXCEPTION_MESSAGE);
        }
        if (attempts < VALID_ATTEMPTS) {
            throw new IllegalArgumentException(ATTEMPTS_EXCEPTION_MESSAGE);
        }

        return new RacingInfo(tokenizedCarNames, attempts);
    }

    public int getCarCount() {

        return carCount;
    }

    public int getAttempts() {

        return attempts;
    }
}
