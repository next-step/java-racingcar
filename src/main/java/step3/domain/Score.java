package step3.domain;

public class Score {
    private final String symbol;
    private String score;

    public Score(String symbol) {
        this.symbol = symbol;
        this.score = symbol;
    }

    public void setScore() {
        this.score += symbol;
    }

    public String getScore() {
        return score;
    }
}
