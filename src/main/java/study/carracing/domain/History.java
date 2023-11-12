package study.carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class History {
    private List<String> scores;

    public History() {
        this.scores = new ArrayList<>();
    }

    public void addScores(RacingCars racingCars) {
        for (Car car : racingCars.getCars()) {
            scores.add(car.toString());
        }
    }

    public List<String> getScores() {
        return scores.stream().collect(Collectors.toUnmodifiableList());
    }
}
