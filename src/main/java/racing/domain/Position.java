package racing.domain;

public class Position {
    private int value;

    public Position(int position) {
        this.value = position;
    }

    public int value() {
        return value;
    }

    public boolean isHighScore(int highScore) {
        return this.value == highScore;
    }

    public void increase() {
        this.value++;
    }
}
