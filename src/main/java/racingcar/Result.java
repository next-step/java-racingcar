package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<CarScore> carScrores;

    public Result(List<CarScore> carScrores) {
        this.carScrores = carScrores;
    }

    public List<CarScore> getCarScores() {
        return carScrores;
    }
}
