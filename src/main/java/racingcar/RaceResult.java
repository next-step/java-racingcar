package racingcar;

import java.util.List;

public class RaceResult {

    private List<CarResult> result;

    public RaceResult(List<CarResult> result) {
        this.result = result;
    }

    public List<CarResult> getResult() {
        return result;
    }

}
