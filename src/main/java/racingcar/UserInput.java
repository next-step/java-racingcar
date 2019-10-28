package racingcar;

import java.util.Arrays;
import java.util.List;

public class UserInput {

    private static final String DELIMITER = ",";

    private String carNames;
    private int runNumber;

    public UserInput(String carNames, int runNumber) {
        this.carNames = carNames;
        this.runNumber = runNumber;
    }

    public List<String> getCarNameList() {
        String[] split = carNames.split(DELIMITER);
        if(split.length == 0) {
            throw new IllegalArgumentException("적어도 한개 이상의 자동차 이름을 입렬해주세요.");
       }
        return Arrays.asList(split);
    }

    public int getRunNumber() {
        return runNumber;
    }
}
