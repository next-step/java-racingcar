package racingcar.external;

import racingcar.dto.RaceReadyValue;
import racingcar.validator.InputValidator;

public class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static RaceReadyValue input(InputChannel inputChannel) {
        String carNames = inputChannel.inputString(INPUT_CAR_NAMES);
        InputValidator.validate(carNames);

        int tryCount = inputChannel.inputNumber(INPUT_TRY_COUNT);

        return RaceReadyValue.of(carNames, tryCount);
    }
}
