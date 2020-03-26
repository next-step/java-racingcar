package racinggame.view;

import racinggame.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 입력값 validate
 * 1. Racing에서 사용 가능 하도록 입력값 변환 및 저장
 */
public class InputView {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String INPUT_ERROR_MESSAGE = "1이상의 값을 입력해야 합니다.";
    private static final int RACING_MINIMUM_ROUND_COUNT = 1;
    private int gameCount;
    private List<String> carNames = new ArrayList<>();

    public InputView(String gameCount, String carNames) {
        this.gameCount = validateInputInteger(gameCount);
        this.carNames = careateCarNames(carNames);
    }

    private int validateInputInteger(String input) {
        int num = NumberUtil.validateIntegerAndReturn(input);
        if (!NumberUtil.isGreaterThan(num, RACING_MINIMUM_ROUND_COUNT)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return num;
    }

    private List<String> careateCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
