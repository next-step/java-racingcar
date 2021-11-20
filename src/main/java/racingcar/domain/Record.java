package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Record {

    private final List<Score> scores;

    public Record(List<Score> scores) {
        this.scores = scores;
    }

    public static Record from(RacingCars racingCars) {
        return new Record(racingCars.getValues()
                .stream()
                .map(Score::of)
                .collect(collectingAndThen(toList(), Collections::unmodifiableList)));
    }

    public List<Score> getScores() {
        return scores;
    }

    private Position getMaxPosition() {
        return scores.stream()
                .map(Score::getPosition)
                .max(Comparator.comparing(Position::getValue))
                .orElse(Position.ZERO_POSITION);
    }

    public List<Name> getWinner() {
        Position maxPosition = getMaxPosition();
        return scores.stream()
                .filter(value -> value.isWinner(maxPosition))
                .map(Score::getName)
                .collect(toList());
    }
}
