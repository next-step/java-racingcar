package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Score {
    private final HashMap<String, Integer> score = new HashMap<>();

    public Score(List<Car> carList) {
        scoring(carList);
    }

    public HashMap<String, Integer> getScore() {
        return score;
    }

    private void scoring(List<Car> carList) {
        for (Car car : carList) {
            score.put(car.name(), car.distanceDriven());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;

        Score score1 = (Score) o;
        return Objects.equals(score, score1.score);
    }

    @Override
    public int hashCode() {
        return score != null ? score.hashCode() : 0;
    }
}
