package racing.model;

public class Position {
    private static final String HYPHEN = "-";
    private String result;

    public Position(int score) {
        this.result = HYPHEN.repeat(score);
    }

    public String getResult() {
        return this.result;
    }

}
