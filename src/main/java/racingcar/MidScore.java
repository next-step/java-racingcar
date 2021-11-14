package racingcar;

import java.util.List;

public class MidScore {

    private final int[] scores;

    public MidScore(List<Car> cars) {
        this.scores = cars.stream().mapToInt(Car::getLocation).toArray();
    }

    public int[] getScores() {
        return scores;
    }
}
