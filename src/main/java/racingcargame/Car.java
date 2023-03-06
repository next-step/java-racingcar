package racingcargame;

public class Car {
    private final String name;
    private int score; //현재점수

    public Car(final String name, final int score) {
        this.name = name;
        this.score = score;
    }

    int getScore() {
        return this.score;
    }

    void setScore(final int score) {
        this.score = score;
    }

    void addScore() {
        this.score++;
    }

    String getName() {
        return this.name;
    }
}