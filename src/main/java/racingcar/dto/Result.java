package racingcar.dto;

public class Result {
    private final String name;
    private final int score;

    public Result(final String name, final int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
