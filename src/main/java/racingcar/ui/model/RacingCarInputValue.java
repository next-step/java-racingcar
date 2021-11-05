package racingcar.ui.model;

import racingcar.value.Round;
import racingcar.utils.Preconditions;

import java.util.Arrays;
import java.util.List;

public class RacingCarInputValue {
    private static final int MINIMUM_SIZE = 0;
    private static final String DELIMITER = ",";

    private final List<String> carNames;
    private final Round finalRound;

    private RacingCarInputValue(List<String> carNames, Integer finalRound) {
        Preconditions.checkNotNull(carNames, "carNames은 필수값입니다.");
        Preconditions.checkNotNull(finalRound, "finalRound는 필수값입니다.");
        Preconditions.checkMinimumSize(carNames.size(), MINIMUM_SIZE,
                                       String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.", MINIMUM_SIZE));
        Preconditions.checkMinimumSize(finalRound, MINIMUM_SIZE,
                                       String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.", MINIMUM_SIZE));

        this.carNames = carNames;
        this.finalRound = Round.from(finalRound);
    }

    public static RacingCarInputValue of(String carNames, Integer finalRound) {
        return new RacingCarInputValue(splitNames(carNames), finalRound);
    }

    private static List<String> splitNames(String carNames) {
        return Arrays.asList(carNames.split(DELIMITER));
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Round getFinalRound() {
        return finalRound;
    }
}
