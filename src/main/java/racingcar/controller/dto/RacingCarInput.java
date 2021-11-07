package racingcar.controller.dto;

import racingcar.service.value.Round;
import racingcar.utils.Preconditions;

import java.util.List;

public class RacingCarInput {
    private static final int MINIMUM_SIZE = 0;

    private final List<String> carNames;
    private final Round finalRound;

    private RacingCarInput(List<String> carNames, Integer finalRound) {
        Preconditions.checkNotNull(carNames, "carNames은 필수값입니다.");
        Preconditions.checkNotNull(finalRound, "finalRound는 필수값입니다.");
        Preconditions.checkMinimumSize(carNames.size(), MINIMUM_SIZE,
                                       String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.", MINIMUM_SIZE));
        Preconditions.checkMinimumSize(finalRound, MINIMUM_SIZE,
                                       String.format("minimumSize(%d) 값보다 큰 값을 입력해 주세요.", MINIMUM_SIZE));

        this.carNames = carNames;
        this.finalRound = Round.from(finalRound);
    }

    public static RacingCarInput of(List<String> carNames, Integer finalRound) {
        return new RacingCarInput(carNames, finalRound);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public Round getFinalRound() {
        return finalRound;
    }
}
