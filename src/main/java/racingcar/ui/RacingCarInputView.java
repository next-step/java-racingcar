package racingcar.ui;

import racingcar.ui.model.RacingCarInputValue;
import racingcar.utils.InputUtils;

public class RacingCarInputView implements InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_FINAL_ROUND_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public RacingCarInputValue getInputValue() {
        String carNames = getCarNames();
        Integer finalRoundCount = getFinalRoundCount();
        return RacingCarInputValue.of(carNames, finalRoundCount);
    }

    private String getCarNames() {
        return InputUtils.inputString(INPUT_CAR_NAMES_MESSAGE);
    }

    private Integer getFinalRoundCount() {
        return InputUtils.inputInt(INPUT_FINAL_ROUND_COUNT_MESSAGE);
    }
}