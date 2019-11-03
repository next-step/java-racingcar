package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    public static final String DELIMITER = ",";

    private String carNames;
    private int runCount;

    public UserInput(String carNames, int runCount) {
        this.carNames = carNames;
        this.runCount = runCount;
    }

    public List<String> getCarNames() {
        String[] split = carNames.split(DELIMITER);
        if(split.length == 0) {
            throw new IllegalArgumentException("적어도 한개 이상의 자동차 이름을 입력해주세요.");
       }
        return Arrays.asList(split);
    }

    public int getRunCount() {
        return runCount;
    }
}
