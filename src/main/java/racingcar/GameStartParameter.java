package racingcar;

import java.util.List;

public class GameStartParameter {

    private final List<String> carNames;
    private final int carNums;
    private final int runNums;

    public GameStartParameter(List<String> carNames, int runNums) {
        this.carNames = carNames;
        this.carNums = carNames.size();
        if (!isValidCarNumber(carNums)) {
            throw new IllegalArgumentException("차 입력 개수가 유효하지 않습니다.");
        }
        this.runNums = runNums;
    }

    public int getCarNums() {
        return carNums;
    }

    public int getRunNums() {
        return runNums;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    boolean isValidCarNumber(int carNums) {
        return carNums > 0;
    }
}
