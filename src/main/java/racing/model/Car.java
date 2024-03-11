package racing.model;

public class Car {
    private String name;
    private int score;

    public Car(String name) {
        this(name, 0);
    }

    private Car(String name, int score) {
        if (!isValidCarName(name)) {
            throw new IllegalArgumentException("Invalid Name : " + name);
        }
        this.name = name;
        this.score = score;
    }

    private boolean isValidCarName(String name) {
        return !name.isBlank() && name.length() <= 5;
    }

    public void move(CarMovementStrategy carMovementStrategy) {
        if (carMovementStrategy.movable()) {
            score++;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getPosition(String mark) {
        return mark.repeat(this.score);
    }

    public boolean isWinner(int maxScore) {
        return this.score == maxScore;
    }

    public int getScoreGreaterThan(int maxScore) {
        return score >= maxScore ? score : maxScore;
    }
}
