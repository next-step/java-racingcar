package racingcar.ui.model;

import racingcar.utils.Preconditions;

import java.util.Arrays;
import java.util.List;

public class RacingCarInputValue {
    private static final int LIMIT = 0;
    private static final String DELIMITER = ",";

    private final List<String> carNames;
    private final Integer totalRaceCount;

    private RacingCarInputValue(List<String> carNames, Integer totalRaceCount) {
        Preconditions.checkNotNull(carNames, "carNames은 필수값입니다.");
        Preconditions.checkNotNull(totalRaceCount, "totalRaceCount은 필수값입니다.");
        Preconditions.checkNumber(carNames.size(), LIMIT, String.format("limit(%d) 값보다 큰 값을 입력해 주세요.", LIMIT));
        Preconditions.checkNumber(totalRaceCount, LIMIT, String.format("limit(%d) 값보다 큰 값을 입력해 주세요.", LIMIT));

        this.carNames = carNames;
        this.totalRaceCount = totalRaceCount;
    }

    public static RacingCarInputValue of(String carNames, Integer totalRaceCount) {
        return new RacingCarInputValue(splitNames(carNames), totalRaceCount);
    }

    private static List<String> splitNames(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getTotalRaceCount() {
        return totalRaceCount;
    }
}
