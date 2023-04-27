package racingcar.model;

public class RoundScore {

    private final String carName;
    private final int score;

    public RoundScore(String carName, int score) {
        this.carName = carName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return carName;
    }

    public boolean hasMaxDistance(int maxScore) {
        return this.score == maxScore;
    }

}
