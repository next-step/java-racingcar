package racingcar;

import java.util.Map;

public class RacingInputData {
    private final Map<String, Integer> inputData;

    public RacingInputData(Map<String, Integer> inputData) {
        this.inputData = inputData;
    }

    public int getCarNumber(String key) {
        return inputData.get(key);
    }

    public int getTryNumber(String key) {
        return inputData.get(key);
    }
}
