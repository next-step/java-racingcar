package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class MidScore {

    private final List<Integer> scores;

    public MidScore(List<Car> cars) {
        this.scores = cars.stream()
                .mapToInt(Car::getLocation)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getScores() {
        return scores;
    }
}
