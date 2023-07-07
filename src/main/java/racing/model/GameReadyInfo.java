package racing.model;

import calculator.util.StringUtils;
import java.util.List;
import racing.exception.GameReadyException;
import racing.factory.CarFactory;

public class GameReadyInfo {

    private static final String DEFAULT_DELIMITER = ",";

    private final Cars cars;
    private final int tryCount;

    public GameReadyInfo(final String carNames, final int tryCount) {
        validate(carNames, tryCount);
        this.cars = CarFactory.getInstance()
                              .manufactureCars(split(carNames));
        this.tryCount = tryCount;
    }

    public Cars getCars() {
        return this.cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void validate(final String carNames, final int tryCount) {
        validateCarNames(carNames);
        validateTryCount(tryCount);
    }

    private static void validateCarNames(final String carNames) {
        if (StringUtils.hasNotText(carNames)) {
            throw new GameReadyException("차 이름을 입력해야 합니다.");
        }
    }

    private static void validateTryCount(final int raceCount) {
        if (raceCount <= 0) {
            throw new GameReadyException("경기 횟수는 양수이어야 합니다.");
        }
    }

    private static List<String> split(final String carNames) {
        return List.of(carNames.split(DEFAULT_DELIMITER));
    }
}
