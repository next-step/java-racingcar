package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<CarScore> carScrores = new ArrayList<>();

    public Result(List<CarScore> carScrores) {
        this.carScrores = carScrores;
    }

    public List<CarScore> getCarScores() {
        return carScrores;
    }
}
