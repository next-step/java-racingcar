package racingcar.model;

import java.util.Map;

public class Result {
    private Map<String, Integer> result;

    public Result(Map<String, Integer> result) {
        this.result = result;
    }

    public Map<String, Integer> getResult() {
        return result;
    }

    public Integer getCurrentPosition(String carName) {
        return this.getResult().get(carName);
    }
}