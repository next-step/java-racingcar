package racingcar;

import java.util.List;

public class RoundResult {

    private List<CarResult> result;

    public RoundResult(List<CarResult> result) {
        this.result = result;
    }

    public List<CarResult> getResult() {
        return result;
    }

}
