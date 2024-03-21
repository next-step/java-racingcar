package RacingGame.model;

public class Position {
    private int number;

    public Position() {
        this(0);
    }

    public Position(int number) {
        this.number = number;
    }

    public int getPosition() {
        return this.number;
    }

    public void increase() {
        this.number++;
    }

    public boolean equals(int number) {
        return this.number == number;
    }
}
