package racingcar.external;

import racingcar.dto.RaceReadyValue;

public class InputView {

    private static final String INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static RaceReadyValue input(InputChannel inputChannel) {
        int carCount = inputChannel.input(INPUT_CAR_COUNT);
        int tryCount = inputChannel.input(INPUT_TRY_COUNT);

        return new RaceReadyValue(carCount, tryCount);
    }
}
