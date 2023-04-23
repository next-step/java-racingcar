package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Scores {

    private final List<Score> scores;

    public Scores() {
        scores = new ArrayList<>();
    }

    public void addScore(Score score) {
        scores.add(score);
    }

    public List<Score> findAllScores() {
        return Collections.unmodifiableList(scores);
    }

    public List<String> findWinnerNames() {
        List<Score> winners = findWinners();
        return winners.stream()
                .map(Score::findCarName)
                .collect(Collectors.toList());
    }

    public List<Score> findWinners() {
        int maxPoint = findMaxPoint();
        List<Score> winner = scores.stream()
                .filter(score -> score.findPoint() == maxPoint)
                .collect(Collectors.toList());
        return winner;
    }

    public int findMaxPoint() {
        return scores.stream()
                .mapToInt(Score::findPoint)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
