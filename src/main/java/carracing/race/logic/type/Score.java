package carracing.race.logic.type;

public class Score {
    private final int value;

    public Score(int value) {
        this.value = value;
    }

    public int toInt() {
        return value;
    }

    public String toProgress() {
        return value > 4 ? "-" : "";
    }
}
