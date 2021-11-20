package racingcar.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Record {

    private final List<Score> scores;

    public Record(List<Score> scores) {
        this.scores = scores;
    }

    public static Record from(RacingCars racingCars) {
        List<Score> scores = racingCars.getValues()
                .stream()
                .map(Score::of)
                .collect(Collectors.toList());

        return new Record(Collections.unmodifiableList(scores));
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
                .collect(Collectors.toList());
    }
}
