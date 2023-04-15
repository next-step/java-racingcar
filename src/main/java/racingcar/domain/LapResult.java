package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class LapResult {

    private final List<Car> lapResult;

    public LapResult(List<Car> lapResult) {
        this.lapResult = lapResult;
    }

    public List<Car> cars() {
        return new ArrayList<>(lapResult);
    }

}
