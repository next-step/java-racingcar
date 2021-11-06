package racingcar.ui;

import racingcar.controller.dto.RacingCarInput;
import racingcar.utils.InputUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarInputView implements InputView {
    private static final String DELIMITER = ",";
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String WRONG_CAR_NAME = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final int CAR_NAME_MAXIMUM_SIZE = 5;

    public RacingCarInput getInputValue() {
        List<String> carNames = getCarNames();
        Integer finalRound = getFinalRound();
        return RacingCarInput.of(carNames, finalRound);
    }

    private List<String> getCarNames() {
        String carNames = InputUtils.inputString(INPUT_CAR_NAME);

        return Arrays.stream(carNames.split(DELIMITER))
                .filter(this::checkCarName)
                .collect(Collectors.toList());
    }

    private Integer getFinalRound() {
        return InputUtils.inputInt(INPUT_TRY_COUNT);
    }

    private boolean checkCarName(String carName) {
        if (carName.length() > CAR_NAME_MAXIMUM_SIZE) {
            throw new IllegalArgumentException(WRONG_CAR_NAME);
        }
        return true;
    }

}