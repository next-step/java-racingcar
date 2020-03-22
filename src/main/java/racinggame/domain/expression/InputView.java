package racinggame.domain.expression;

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
    private int carCount;
    private int gameCount;
    private List<String> carNames = new ArrayList<>();

    public InputView(String carCount, String gameCount, String carNames) {
        this.carCount = validateInputData(carCount);
        this.gameCount = validateInputData(gameCount);
        this.carNames = careateCarNames(carNames);
        validateCompareCarAndNameCount();
    }

    private int validateInputData(String input) {
        int num = NumberUtil.validateIntegerAndReturn(input);
        if (!NumberUtil.isGreaterThan1(num)) {
            throw new IllegalArgumentException("1이상의 값을 입력해야 합니다.");
        }
        return num;
    }

    private void validateCompareCarAndNameCount() {
        if (this.carCount != this.carNames.size()) {
            throw new IllegalArgumentException("자동차와 자동차의 이름의 갯수가 서로 맞지 않습니다.");
        }
    }

    private List<String> careateCarNames(String carNames) {
        return Arrays.asList(carNames.split(CAR_NAME_DELIMITER));
    }

    public int getCarCount() {
        return this.carCount;
    }

    public int getGameCount() {
        return this.gameCount;
    }

    public List<String> getCarNames() {
        return this.carNames;
    }
}
