package racingcar.ui.model;

import racingcar.utils.Preconditions;

import java.util.Arrays;
import java.util.List;

public class RacingCarInputValue {
    private static final int MINIMUM_SIZE = 0;
    private static final String DELIMITER = ",";

    private final List<String> carNames;
    private final Integer finalRoundCount;

    private RacingCarInputValue(List<String> carNames, Integer finalRoundCount) {
        Preconditions.checkNotNull(carNames, "carNames은 필수값입니다.");
        Preconditions.checkNotNull(finalRoundCount, "finalRoundCount는 필수값입니다.");
        Preconditions.checkNumber(carNames.size(), MINIMUM_SIZE,
                                  String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.", MINIMUM_SIZE));
        Preconditions.checkNumber(finalRoundCount, MINIMUM_SIZE,
                                  String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.", MINIMUM_SIZE));

        this.carNames = carNames;
        this.finalRoundCount = finalRoundCount;
    }

    public static RacingCarInputValue of(String carNames, Integer finalRoundCount) {
        return new RacingCarInputValue(splitNames(carNames), finalRoundCount);
    }

    private static List<String> splitNames(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Integer getFinalRoundCount() {
        return finalRoundCount;
    }
}
