package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RoundScores {

    private final List<RoundScore> roundScores;

    public RoundScores(List<RoundScore> roundScores) {
        this.roundScores = roundScores;
    }

    public List<String> getWinner() {
        int maxDistance = getMaxDistance();
        return roundScores.stream()
                .filter(car -> car.hasMaxDistance(maxDistance))
                .map(RoundScore::getName)
                .collect(Collectors.toList());
    }

    public int getMaxDistance() {
        int maxScore = 0;
        for (RoundScore roundScore : roundScores) {
            if (roundScore.getScore() > maxScore) {
                maxScore = roundScore.getScore();
            }
        }

        return maxScore;
    }

    public List<RoundScore> getScores() {
        return Collections.unmodifiableList(this.roundScores);
    }

}
