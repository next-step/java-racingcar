package racingcar.view;

import racingcar.domain.GameInputData;
import racingcar.service.util.InputUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarInputView implements InputView {

    private static final String DELIMITER = ",";
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT= "시도할 회수는 몇 회 인가요?";
    private static final int CAR_NAME_MAXIMUM_SIZE = 5;

    public  GameInputData getRacingCarInput() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        return GameInputData.of(carNames, tryCount);
    }

    private List<String> getCarNames() {
        String carNames = InputUtil.inputString(INPUT_CAR_NAME);

        return Arrays.stream(carNames.split(DELIMITER))
                .filter(this::checkCarName)
                .collect(Collectors.toList());
    }

    private boolean checkCarName(String carName) {
        if(carName.length() > CAR_NAME_MAXIMUM_SIZE) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과 할 수 없습니다!!!");
        }

        return true;
    }

    private int getTryCount() {

        return InputUtil.inputData(INPUT_TRY_COUNT);
    }

}
